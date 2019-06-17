package com.chandler.hysrtix.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * 启动类-熔断器hystrix测试
 *
 * @author 钱丁君-chandler 2019/5/16下午6:28
 * @since 1.8
 */
@SpringBootConfiguration
@EnableCircuitBreaker
public class Application {
        public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
        }


}
