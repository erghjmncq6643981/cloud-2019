
package com.chandler.instance.client.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryClientConfiguration;
import org.springframework.cloud.consul.serviceregistry.ConsulAutoServiceRegistrationAutoConfiguration;
import org.springframework.cloud.consul.serviceregistry.ConsulServiceRegistryAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 服务提供者-eureka，consul客户端
 * 
 * @version
 * @author kyle 2019年5月9日下午6:25:00
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
