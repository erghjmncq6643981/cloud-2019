/*
 * chandler-prometheus
 * 2020/2/29 9:18 AM
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
 * @author 钱丁君-chandler 2020/2/29 9:18 AM
 * @version 1.0.0
 * @since 1.8
 */
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Metric {
    String value() default "";
    MetricType type();
    Label[] labels();
}
