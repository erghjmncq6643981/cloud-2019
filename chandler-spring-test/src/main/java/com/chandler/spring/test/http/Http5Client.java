/*
 * hr-data-sync-server
 * 2024/9/19 09:19
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * Please contact chandler Corporation or visit:
 * https://www.jianshu.com/u/117796446366
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.spring.test.http;

import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.message.BasicHeader;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.net.URIBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * 类功能描述
 *
 * @author 钱丁君-chandler 2024/9/19 09:19
 * @version 1.0.0
 * @since 1.8
 */
@Slf4j
@Component
public class Http5Client {
    private static final String API_KEY = "Basic OTZlMGU1YzgzODhmMjI2ZmQyMTg0NjI3NTE0OGNiYTk6";

    public static String sendGet(String url, Map<String, String> paramsMap,String sign) {
        String resultContent = null;
        HttpGet httpGet = new HttpGet(url);
        // 表单参数
        List<NameValuePair> nvps = new ArrayList<>();
        // GET 请求参数
        paramsMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(e -> nvps.add(new BasicNameValuePair(e.getKey(), e.getValue())));
        // 增加到请求 URL 中
        try {
            httpGet.setHeader(new BasicHeader("Authorization", API_KEY));
            httpGet.setHeader(new BasicHeader("Accept", "application/json; charset=UTF-8"));
            URI uri = new URIBuilder(new URI(url)).addParameters(nvps).addParameter("sign",sign).build();
            httpGet.setUri(uri);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
                int status = response.getCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    // 获取响应信息
                    resultContent = EntityUtils.toString(entity);
                } else if ((status >= 400 && status < 405) || status == 413) {
                    log.warn("httpclient Unexpected response status:{}", status);
                }
            }
        } catch (IOException | ParseException e) {
            log.error("httpclient failure！url：{}；paramsMap：{} ", url, paramsMap, e);
        }
        return resultContent;
    }

    public static String sendPost(String url, String jsonString, Map<String, String> paramsMap) {
        String result = null;
        HttpPost httpPost = new HttpPost(url);
        // 表单参数
        List<NameValuePair> nvps = new ArrayList<>();
        // POST 请求参数
        paramsMap.forEach((key, value) -> nvps.add(new BasicNameValuePair(key, value)));
        httpPost.setEntity(new StringEntity(jsonString, ContentType.parse("UTF-8")));
        // 增加到请求 URL 中
        try {
            httpPost.setHeader(new BasicHeader("Authorization", API_KEY));
            httpPost.setHeader(new BasicHeader("Content-Type", "application/json; charset=UTF-8"));
            httpPost.addHeader(new BasicHeader("Accept", "application/json; charset=UTF-8"));
            URI uri = new URIBuilder(new URI(url)).addParameters(nvps).build();
            httpPost.setUri(uri);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            try (CloseableHttpResponse response = httpclient.execute(httpPost)) {
                System.out.println(response.getVersion()); // HTTP/1.1
                System.out.println(response.getCode()); // 200
                System.out.println(response.getReasonPhrase()); // OK
                int status = response.getCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    // 获取响应信息
                    result = EntityUtils.toString(entity);
                    // 确保流被完全消费
                    EntityUtils.consume(entity);
                } else if ((status >= 400 && status < 405) || status == 413) {
                    log.warn("httpclient Unexpected response status:{}", status);
                }
            }
        } catch (IOException | ParseException e) {
            log.error("httpclient failure！url：{}；jsonString：{}；paramsMap：{} ", url, jsonString, paramsMap, e);
        }
        return result;
    }
}
