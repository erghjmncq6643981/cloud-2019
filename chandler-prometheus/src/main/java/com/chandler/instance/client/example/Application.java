
package com.chandler.instance.client.example;

import com.chandler.instance.client.example.config.PrometheusConfig;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.config.MeterRegistryConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * JAVA prometheus测试工程
 * 
 * @version
 * @author kyle 2019年5月9日下午6:25:00
 * @since 1.8
 */
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    public MeterRegistryCustomizer<MeterRegistry> configurer(){
        return registry -> registry.config().commonTags("application", applicationName);
    }
}
