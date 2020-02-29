/*
 * chandler-prometheus
 * 2020/2/29 9:19 AM
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
 * 标签注解
 *
 * @author 钱丁君-chandler 2020/2/29 9:19 AM
 * @since 1.8
 */
@Inherited
@Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Label {
    /*
     * tag.value
     */
    String value() ;

    /*
     * tag.key
     */
    String name();
}
