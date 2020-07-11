/*
 * chandler-config
 * 2020-07-05 09:33
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * Please contact chandler Corporation or visit:
 * https://www.jianshu.com/u/117796446366
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.instance.client.example.config;

import java.util.Properties;

import com.chandler.instance.client.example.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 类功能描述
 *
 * @author 钱丁君-chandler 2020-07-05 09:33
 * @version 1.0
 * @since 1.8
 */
@Configuration
public class PropertyTest {
    @Value("${chandler.properties.test}")
    private String test;
    @Autowired
    private Properties properties;

    @Bean
    public Person person(){
        System.out.println(test);
        return new Person();
    }

}
