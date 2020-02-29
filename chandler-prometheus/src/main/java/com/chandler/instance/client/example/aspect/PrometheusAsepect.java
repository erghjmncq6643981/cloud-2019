/*
 * chandler-prometheus
 * 2020/2/27 5:57 PM
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

import java.lang.annotation.*;

/**
 * 类功能描述
 *
 * @author 钱丁君-chandler 2020/2/27 5:57 PM
 * @since 1.8
 */
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PrometheusAsepect {
    String value() default "";
    String suffix() default "";
    Metric[] mertics();
}
