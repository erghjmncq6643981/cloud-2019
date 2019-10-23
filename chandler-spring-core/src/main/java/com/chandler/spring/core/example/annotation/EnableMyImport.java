/*
 * chandler-spring-core
 * 2019/10/23 1:35 PM
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * Please contact chandler Corporation or visit:
 * https://www.jianshu.com/u/117796446366
 *
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.spring.core.example.annotation;

import com.chandler.spring.core.example.autoconfigure.MyImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 激活注册-激活Person
 *
 * @author 钱丁君-chandler 2019/10/231:35 PM
 * @version 1.0.0
 * @since 1.8
 */
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MyImportBeanDefinitionRegistrar.class)
public @interface EnableMyImport {
}
