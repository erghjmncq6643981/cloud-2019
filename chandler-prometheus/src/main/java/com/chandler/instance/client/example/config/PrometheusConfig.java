/*
 * chandler-prometheus
 * 2020/2/27 4:21 PM
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * Please contact chandler Corporation or visit:
 * https://www.jianshu.com/u/117796446366
 *
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.instance.client.example.config;

import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import io.prometheus.client.CollectorRegistry;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 类功能描述
 *
 * @author 钱丁君-chandler 2020/2/27 4:21 PM
 * @version 1.0.0
 * @since 1.8
 */
//@Configuration
public class PrometheusConfig {
    @Value("${spring.application.name}")
    private String applicationName;

//    @Bean
//    @Primary
    public CollectorRegistry serviceCollectorRegistry() {
        return new CollectorRegistry();
    }

//    @Bean
//    @Primary
    public PrometheusMeterRegistry servicePrometheusMeterRegistry(@Qualifier("serviceCollectorRegistry") final CollectorRegistry collectorRegistry, final MeterBinder... binders) {
        final PrometheusMeterRegistry registry = new PrometheusMeterRegistry(io.micrometer.prometheus.PrometheusConfig.DEFAULT, collectorRegistry, Clock.SYSTEM);
        return registry;
    }

    @Bean
    public MeterRegistryCustomizer<MeterRegistry> configurer(){
        return registry -> registry.config().commonTags("application", applicationName);
    }


}
