/*
 * chandler-spring-core
 * 2019/10/22 6:04 PM
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * Please contact chandler Corporation or visit:
 * https://www.jianshu.com/u/117796446366
 *
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.spring.core.example;

import com.chandler.spring.core.example.config.SpringCoreTestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Spring生命周期测试-测试用例
 *
 * @author 钱丁君-chandler 2019/10/226:04 PM
 * @version 1.0.0
 * @since 1.8
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringCoreTest {

    @Test
    public void test(){
        //1、创建ioc容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringCoreTestConfig.class);
        System.out.println("容器创建完成...");
        applicationContext.getBean("car");
        //关闭容器
        applicationContext.close();
    }
}
