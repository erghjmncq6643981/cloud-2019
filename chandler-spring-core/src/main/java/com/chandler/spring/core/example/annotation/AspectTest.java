/*
 * chandler-spring-core
 * 2019/10/22 7:03 PM
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

import java.lang.annotation.*;

/**
 * 类功能描述
 *
 * @author 钱丁君-chandler 2019/10/227:03 PM
 * @since 1.8
 */
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AspectTest {

    /**
     * 参数
     */
    String[] value();
}
