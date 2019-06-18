/*
 * chandler-gateway-server
 * 2019/5/21 上午11:09
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.gateway.server.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryClientConfiguration;
import org.springframework.cloud.consul.serviceregistry.ConsulAutoServiceRegistrationAutoConfiguration;
import org.springframework.cloud.consul.serviceregistry.ConsulServiceRegistryAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 网关路由gateway-eureka，consul客户端
 *
 * @author 钱丁君-chandler 2019/5/21上午11:09
 * @since 1.8
 */

@EnableEurekaClient
//@EnableDiscoveryClient
@SpringBootApplication(exclude = {
//        EurekaClientAutoConfiguration.class
        ConsulAutoServiceRegistrationAutoConfiguration.class,
        ConsulDiscoveryClientConfiguration.class,
        ConsulServiceRegistryAutoConfiguration.class
})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
