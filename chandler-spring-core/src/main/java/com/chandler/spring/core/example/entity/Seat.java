/*
 * chandler-spring-core
 * 2019/10/22 5:56 PM
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * Please contact chandler Corporation or visit:
 * https://www.jianshu.com/u/117796446366
 *
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.spring.core.example.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * 类功能描述
 *
 * @author 钱丁君-chandler 2019/10/225:56 PM
 * @version 1.0.0
 * @since 1.8
 */
@Data
public class Seat {
    @Value("${person.car.number:2}")
    private String number;
}
