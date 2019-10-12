/*
 * RMP
 * 2019/8/21 下午2:56
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

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.DefaultedHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * HttpClient封装类
 *
 * @author 钱丁君-chandler 2019/8/21下午2:56
 * @since 1.8
 */
    public class AuthorizationHttp {

    private static Logger logger = LoggerFactory.getLogger(AuthorizationHttp.class);
    private static final String appIdKey = "c78c3fac730c4347901176240b83e3d8,a96e2597f3ea4daa92faef4030bd120a";

    public static String sendGet(String url, Map<String,String> paramsMap){
        HttpParams params=new BasicHttpParams();
        paramsMap.forEach((k,y)->{
            params.setParameter(k,y);
        });
        JSONObject jsonObject = null;
        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        try {
            /**
             * 创建HttpClient对象
             */
            client = HttpClients.createDefault();
            /**
             * 创建URIBuilder
             */
            URIBuilder uriBuilder = new URIBuilder(url);
            /**
             * 创建HttpGet
             */
            HttpGet httpGet = new HttpGet(uriBuilder.build());
            /**
             * 设置请求头部验证信息
             */
            httpGet.setHeader(new BasicHeader("Authorization", appIdKey));
            /**
             * 设置返回编码
             */
            httpGet.setHeader(new BasicHeader("Accept", "application/json; charset=UTF-8"));
            httpGet.setParams(params);

            response = client.execute(httpGet);
            // 初始化: 解密结果
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                return EntityUtils.toString(entity, StandardCharsets.UTF_8);
            } else if ((status >= 400 && status < 405) || status == 413) {
                logger.info("Unexpected response status: " + status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //自定义
        return null;
    }

    public static String sendPost(String url, String jsonStringParams){
        HttpEntity requestEntity = new StringEntity(jsonStringParams, "UTF-8");
        JSONObject jsonObject = null;
        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        try {
            /**
             * 创建HttpClient对象
             */
            client = HttpClients.createDefault();
            /**
             * 创建URIBuilder
             */
            URIBuilder uriBuilder = new URIBuilder(url);
            /**
             * 创建httpPost
             */
            HttpPost httpPost = new HttpPost(uriBuilder.build());
            /**
             * 设置请求头部编码
             */
            httpPost.setHeader(new BasicHeader("Content-Type", "application/json; charset=UTF-8"));
            httpPost.setHeader(new BasicHeader("Authorization", appIdKey));
            /**
             * 设置返回编码
             */
            httpPost.setHeader(new BasicHeader("Accept", "application/json; charset=UTF-8"));

            httpPost.setEntity(requestEntity);

            response = client.execute(httpPost);
            // 初始化: 解密结果
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                return EntityUtils.toString(entity, StandardCharsets.UTF_8);
            } else if ((status >= 400 && status < 405) || status == 413) {
                logger.info("Unexpected response status: " + status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //自定义
        return null;
    }

}
