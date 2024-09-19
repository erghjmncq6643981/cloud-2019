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
public class HttpClient5Test {

    @Test
    public void get() {
        Map<String, String> params = new HashMap<>();
        params.put("apiCode", "7b1c6fe7ce14a58ec1335499cf310d22");
        params.put("entCode", "96e0e5c8388f226fd21846275148cba9");
        params.put("nonce", "3f12432d");
        params.put("timestamp", "1726716147153");
        String sign="lwiKhs5ijMfUhq83mGmQNnsgwH6tVxFQ2S3tE2emp6gKTpBOcwdFFWvsugbdmhGkEAStHhi/8oF9QKGmK09z3XIVWiUxjcK4CWsyxSvn1GSTW4PG3lKy5/v6PlBBImoQlOULAUXmEieZ4gPUFzB7k0+sZpSa1B0MLQ+4S3Mrlno=";
        String response = Http5Client.sendGet("https://api.mokahr.com/api-platform/hcm/oapi/v1/org/department/batchData",
                params, sign);
        System.out.println(response);
    }

    @Test
    public void post() {
        Singer singer = new Singer();
        singer.setFirstName("qian");
        singer.setLastName("chandler");
        singer.setVersion(1);
        String response = AuthorizationHttp.sendPost("https://httpbin.org/post", JSON.toJSONString(singer));
        System.out.println(response);
    }
}
