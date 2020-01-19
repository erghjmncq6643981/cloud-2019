/*
 * chandler-spring-webflux
 * 2020/1/19 11:36 AM
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * Please contact chandler Corporation or visit:
 * https://www.jianshu.com/u/117796446366
 *
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.spring.webflux.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 测试对象
 *
 * @author 钱丁君-chandler 2020/1/19 11:36 AM
 * @version 1.0.0
 * @since 1.8
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Good implements Serializable {
    private int id;
    private String name;
    private String price;
}
