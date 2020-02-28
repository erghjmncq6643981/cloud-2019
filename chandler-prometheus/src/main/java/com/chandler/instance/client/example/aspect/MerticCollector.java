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

import com.google.common.collect.Lists;
import io.micrometer.core.instrument.*;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 接口信息监控
 *
 * @author 钱丁君-chandler 2020/2/27 5:28 PM
 * @version 1.0.0
 * @since 1.8
 */
@Aspect
@Slf4j
@Component
public class MerticCollector {
    @Autowired
    private PrometheusMeterRegistry registry;
    private Counter counter;
    private Timer timer;
    private AtomicInteger intGauge;
    private DistributionSummary summary;

    @PostConstruct
    private void init() { //这些变量的变化会被监控
        counter = registry.counter("httpin_req_total", "listCount", "listCount");
        intGauge = registry.gauge("httpin_rate", Lists.newArrayList(new ImmutableTag("env", "test")), new AtomicInteger());
        timer=registry.timer("httpin_duration_tinme","env", "test");
        summary = registry.summary("api_summary", "env", "test");
    }

    @Pointcut("@annotation(com.chandler.instance.client.example.aspect.PrometheusAsepect)")
    private void mqPrometheusMethodPointCut() {
    }

    @Around("mqPrometheusMethodPointCut()")
    public Object arround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object retObj = joinPoint.proceed();
        summary.record(System.currentTimeMillis() - start);
        counter.increment();

        // 获取方法的相关信息
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        RequestMapping requestMapping;
        if(method.isAnnotationPresent(RequestMapping.class)){
            requestMapping = method.getAnnotation(RequestMapping.class);
        }

        PrometheusAsepect prometheusAsepect;
        if(method.isAnnotationPresent(PrometheusAsepect.class)){
            prometheusAsepect = method.getAnnotation(PrometheusAsepect.class);
        }

        Object[] args=joinPoint.getArgs();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = attributes.getRequest();
        Duration.ofMillis(System.currentTimeMillis() - start);
        timer.record(Duration.ofMillis(System.currentTimeMillis() - start));
//        timer.record(System.currentTimeMillis() - start, TimeUnit.MILLISECONDS);
        return retObj;
    }

}
