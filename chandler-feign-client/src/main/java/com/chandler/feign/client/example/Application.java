/*
 * chandler-feign-client
 * 2019/5/17 下午4:14
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.feign.client.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryClientConfiguration;
import org.springframework.cloud.consul.serviceregistry.ConsulAutoServiceRegistrationAutoConfiguration;
import org.springframework.cloud.consul.serviceregistry.ConsulServiceRegistryAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Feign服务调用者-eureka，consul客户端
 *
 * @author 钱丁君-chandler 2019/5/17下午4:14
 * @since 1.8
 */
//@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication(exclude = {
        EurekaClientAutoConfiguration.class
//        ConsulAutoServiceRegistrationAutoConfiguration.class,
//        ConsulDiscoveryClientConfiguration.class,
//        ConsulServiceRegistryAutoConfiguration.class
})
@RibbonClient(value = "service-instance-peer")
@EnableFeignClients(basePackages = { "com.chandler.feign.client.example.inter" })
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
