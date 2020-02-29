/*
 * chandler-prometheus
 * 2020/2/27 5:28 PM
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * Please contact chandler Corporation or visit:
 * https://www.jianshu.com/u/117796446366
 *
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.instance.client.example.aspect;

import io.micrometer.prometheus.PrometheusMeterRegistry;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 接口监控指标采集器
 *
 * @author 钱丁君-chandler 2020/2/27 5:28 PM
 * @version 1.0.0
 * @since 1.8
 */
@Aspect
@Slf4j
@Component
@Data
public class MerticCollector {
    @Autowired
    private PrometheusMeterRegistry registry;
    private Object retObj;

    @Pointcut("@annotation(com.chandler.instance.client.example.aspect.PrometheusAsepect)")
    private void mqPrometheusMethodPointCut() {
    }

    @Around("mqPrometheusMethodPointCut()")
    public Object arround(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取方法的相关信息
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        //解析上报指标
        if (method.isAnnotationPresent(PrometheusAsepect.class)) {
            PrometheusAsepect prometheusAsepect = method.getAnnotation(PrometheusAsepect.class);
            Map<String, PrometheusMetric> prometheusMetrics = getMetric(prometheusAsepect);

            Object[] args = joinPoint.getArgs();
            //获取所有参数上的注解
            Annotation[][] parameterAnnotations = signature.getMethod().getParameterAnnotations();
            Arrays.stream(parameterAnnotations).forEach(parameterAnnotation -> {
                int paramIndex = ArrayUtils.indexOf(parameterAnnotations, parameterAnnotation);
                Arrays.stream(parameterAnnotation).forEach(annotation -> {
                    Object paramValue = args[paramIndex];
                    if (paramValue instanceof String) {
                        String param = (String) paramValue;
                        if (annotation instanceof MetricSuffix) {
                            prometheusMetrics.forEach((k, prometheusMetric) -> {
                                prometheusMetric.setSuffix(param);
                            });
                        }
                        if (annotation instanceof Label) {
                            Label label = (Label) annotation;
                            prometheusMetrics.forEach((k, prometheusMetric) -> {
                                prometheusMetric.addLabel(label.name(), param);
                            });
                        }
                    }
                });
            });


            prometheusMetrics.forEach((k, prometheusMetric) -> {
                switch (prometheusMetric.getType()) {
                    case counter:
                        registry.counter(prometheusMetric.getMetricName(), prometheusMetric.getTags()).increment();
                        break;
                    case gauvge:
                        registry.gauge(prometheusMetric.getMetricName(), prometheusMetric.getTags(), 1.0);
                        break;
                    case timer:
                        long start = System.currentTimeMillis();
                        try {
                            retObj = joinPoint.proceed();
                        } catch (Throwable e) {
                            log.warn("执行失败，原因：{}", e.getMessage());
                        }
                        registry.timer(prometheusMetric.getMetricName(), prometheusMetric.getTags()).record(Duration.ofMillis(System.currentTimeMillis() - start));
                        break;
                    case summary:
                        break;
                    default:
                        break;
                }

            });
        }
        if (null == retObj) {
            retObj = joinPoint.proceed();
        }
        return retObj;
    }

    private Map<String, PrometheusMetric> getMetric(PrometheusAsepect prometheusAsepect) {
        Map<String, PrometheusMetric> prometheusMetricMap = new HashMap<>();
        Metric[] metrics = prometheusAsepect.mertics();
        if (null != metrics && metrics.length != 0) {
            Arrays.stream(metrics).forEach(metric -> {
                PrometheusMetric prometheusMetric = new PrometheusMetric();
                prometheusMetric.setPrefix(prometheusAsepect.value());
                prometheusMetric.setSuffix(prometheusAsepect.suffix());
                prometheusMetric.setName(metric.value());
                prometheusMetric.setType(metric.type());
                if (null != metric.labels() && metric.labels().length != 0) {
                    Arrays.stream(metric.labels()).forEach(label -> {
                        prometheusMetric.addLabel(label.name(), label.value());
                    });
                }
                prometheusMetricMap.put(prometheusMetric.getMetricName(), prometheusMetric);
            });
        }
        return prometheusMetricMap;
    }

}
