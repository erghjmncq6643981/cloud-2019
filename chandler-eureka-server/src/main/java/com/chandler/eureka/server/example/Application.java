package com.chandler.eureka.server.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注册中心服务端
 * 
 * @version
 * @author kyle 2019年5月9日下午6:00:31
 * @since 1.8
 */
@EnableEurekaServer
@SpringBoot月薪17K，养个人随便Application
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
