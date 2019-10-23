/*
 * chandler-spring-core
 * 2019/10/22 5:59 PM
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * Please contact chandler Corporation or visit:
 * https://www.jianshu.com/u/117796446366
 *
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.spring.core.example.config;

import com.chandler.spring.core.example.entity.CarSpringBean;
import com.chandler.spring.core.example.entity.Seat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring生命周期测试配置类
 *
 * @author 钱丁君-chandler 2019/10/225:59 PM
 * @version 1.0.0
 * @since 1.8
 */
@ComponentScan("com.chandler.spring.core.example.autoconfigure")
@Configuration
public class SpringCoreTestConfig {

    @Bean
    public Seat seat(){
        return new Seat();
    }

    @Bean(initMethod = "init",destroyMethod = "detory")
    public CarSpringBean car(){
        return new CarSpringBean();
    }
}
