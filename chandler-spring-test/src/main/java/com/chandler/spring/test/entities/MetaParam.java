/*
 * chandler-spring-test
 * 2024/9/20 13:48
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

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 类功能描述
 *
 * @author 钱丁君-chandler 2024/9/20 13:48
 * @version 1.0.0
 * @since 1.8
 */
@Data
public class MetaParam implements Serializable {
    private static final long serialVersionUID = -3073748461516756164L;

    private String code=null;

    private String client=null;

    private String tag=null;

    private long time=0L;

    public MetaParam(){}

    public MetaParam(String code,String client,String tag){
        this.code=code;
        this.client=client;
        this.tag=tag;
        this.time=System.currentTimeMillis();
    }

}