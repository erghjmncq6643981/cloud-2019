/*
 * chandler-spring-test
 * 2024/9/19 11:50
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * Please contact chandler Corporation or visit:
 * https://www.jianshu.com/u/117796446366
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.spring.test.http;

import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.client5.http.fluent.Response;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.message.BasicHeader;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.net.URIBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 类功能描述
 *
 * @author 钱丁君-chandler 2024/9/19 11:50
 * @version 1.0.0
 * @since 1.8
 */
public class Http5Fluent {
    private static final String appIdKey = "c78c3fac730c4347901176240b83e3d8,a96e2597f3ea4daa92faef4030bd120a";

    public static String sendGet(String url, Map<String, String> paramsMap) {
        String result = null;
        List<NameValuePair> nvps = new ArrayList<>();
        // GET 请求参数
        paramsMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(e -> nvps.add(new BasicNameValuePair(e.getKey(), e.getValue())));
        try {
            URI uri = new URIBuilder(new URI(url)).addParameters(nvps).build();
            Response response = Request.get(uri)
                    .setHeader(new BasicHeader("Authorization", appIdKey))
                    .setHeader(new BasicHeader("Accept", "application/json; charset=UTF-8"))
                    .execute();
            result = response.returnContent().asString();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String sendPost(String url, String body) {
        String result = null;
        Request request = Request.post(url)
                .setHeader(new BasicHeader("Authorization", appIdKey))
                .setHeader(new BasicHeader("Content-Type", "application/json; charset=UTF-8"))
                .setHeader(new BasicHeader("Accept", "application/json; charset=UTF-8"))
                .body(new StringEntity(body, ContentType.parse("UTF-8")));

        try {
            result = request.execute().returnContent().asString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}