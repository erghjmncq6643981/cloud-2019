/*
 * chandler-prometheus
 * 2020/2/29 9:42 AM
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * Please contact chandler Corporation or visit:
 * https://www.jianshu.com/u/117796446366
 *
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.instance.client.example.aspect;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * 类功能描述
 *
 * @author 钱丁君-chandler 2020/2/29 9:42 AM
 * @since 1.8
 */
@Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MetricSuffix {
    @AliasFor("value")
    String name() default "";
    @AliasFor("name")
    String value() default "";
    String defaultValue() default "";
}
