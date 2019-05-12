/*
 * EurekaServerApplication.java
 * 2017年7月9日 下午6:39:15
 * Copyright 2017 Fosun Financial. All  Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * Please contact Fosun Corporation or visit
 * www.fosun.com
 * if you need additional information or have any questions.
 * @author kyle
 * @version 1.0
 */

package com.chandler.instance.client.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.consul.serviceregistry.ConsulAutoServiceRegistrationAutoConfiguration;
import org.springframework.cloud.consul.serviceregistry.ConsulServiceRegistryAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 服务提供者，客户端节点
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
        ConsulServiceRegistryAutoConfiguration.class
})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
