
package com.chandler.spring.core.example;

import com.chandler.spring.core.example.annotation.EnableMyImport;
import com.chandler.spring.core.example.entity.CarSpringBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Spring Boot核心使用方式测试
 * 
 * @version
 * @author kyle 2019年5月9日下午6:25:00
 * @since 1.8
 */
@EnableMyImport
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		CarSpringBean carSpringBean = (CarSpringBean) context.getBean("car");
		System.out.println("启动类" + carSpringBean.toString());
	}
}
