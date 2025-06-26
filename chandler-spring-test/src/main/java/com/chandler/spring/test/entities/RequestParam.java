/*
 * chandler-spring-test
 * 2024/9/20 13:47
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * Please contact chandler Corporation or visit:
 * https://www.jianshu.com/u/117796446366
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.spring.test.entities;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 类功能描述
 *
 * @author 钱丁君-chandler 2024/9/20 13:47
 * @version 1.0.0
 * @since 1.8
 */
@Data
public class RequestParam <R> implements Serializable {
    private static final long serialVersionUID = -2748158148093312858L;

    private MetaParam meta;

    private R params=null;


}