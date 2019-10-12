/*
 * chandler-spring-test
 * 2019/8/23 上午11:24
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * Please contact chandler Corporation or visit:
 * https://www.jianshu.com/u/117796446366
 *
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
 * HttpClient测试
 *
 * @author 钱丁君-chandler 2019/8/23上午11:24
 * @since 1.8
 */
public class HttpClientTest {

    @Test
    public void get(){
        Map<String,String> params=new HashMap<>();
        params.put("test","hello word!");
        params.put("name","chandler");
        String response=AuthorizationHttp.sendGet("https://httpbin.org/get",params);
        System.out.println(response);
    }

    @Test
    public void post(){
        Singer singer=new Singer();
        singer.setFirstName("qian");
        singer.setLastName("chandler");
        singer.setVersion(1);
        String response=AuthorizationHttp.sendPost("https://httpbin.org/post",JSON.toJSONString(singer));
        System.out.println(response);
    }
}
