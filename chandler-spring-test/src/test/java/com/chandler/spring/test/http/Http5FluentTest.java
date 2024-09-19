/*
 * chandler-spring-test
 * 2024/9/19 15:01
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * Please contact chandler Corporation or visit:
 * https://www.jianshu.com/u/117796446366
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.spring.test.http;

import com.alibaba.fastjson.JSON;
import com.chandler.spring.test.entities.Singer;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 类功能描述
 *
 * @author 钱丁君-chandler 2024/9/19 15:01
 * @version 1.0.0
 * @since 1.8
 */
public class Http5FluentTest {
    @Test
    public void get() {
        Map<String, String> params = new HashMap<>();
        params.put("test", "hello word!");
        params.put("name", "chandler");
        String response = Http5Fluent.sendGet("https://httpbin.org/get", params);
        System.out.println(response);
    }

    @Test
    public void post() {
        Singer singer = new Singer();
        singer.setFirstName("qian");
        singer.setLastName("chandler");
        singer.setVersion(1);
        String response = Http5Fluent.sendPost("https://httpbin.org/post", JSON.toJSONString(singer));
        System.out.println(response);
    }
}