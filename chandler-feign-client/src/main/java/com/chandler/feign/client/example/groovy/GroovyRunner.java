/*
 * chandler-feign-client
 * 6/26/21 10:34 AM
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * Please contact chandler Corporation or visit:
 * https://www.jianshu.com/u/117796446366
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.feign.client.example.groovy;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.lang.GroovyResourceLoader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类功能描述
 *
 * @author 钱丁君-chandler 6/26/21 10:34 AM
 * @version 1.0
 * @since 1.8
 */
@Slf4j
public class GroovyRunner {
    public static void main(String[] args) {
        try {
            //从classpath下加载groovy文件
            String path = "classpath:groovy_route.groovy";
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource resource=resolver.getResource(path);
            InputStream input = resource.getInputStream();
            InputStreamReader reader = new InputStreamReader(input);
            BufferedReader br = new BufferedReader(reader);
            StringBuilder template = new StringBuilder();
            for (String line; (line = br.readLine()) != null; ) {
                template.append(line).append("\n");
            }
            //加载GroovyRoute
            GroovyClassLoader classLoader = new GroovyClassLoader();
            Class<IRoute> groovyRouteClass = classLoader.parseClass(template.toString());
            IRoute groovyRoute = groovyRouteClass.newInstance();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 10000; i++) {
                list.add("你好");
                list.add("chandler");
            }
            int runTimes = 10000;
            long st = System.currentTimeMillis();
            for (int j = 0; j < runTimes; j++) {
                groovyRoute.routeList("chandler", list);
            }
            log.info("groovy run :" + (System.currentTimeMillis() - st));
            //使用反射方式调用GroovyRoute的方法
            GroovyObject obj = (GroovyObject) groovyRouteClass.newInstance();
            st = System.currentTimeMillis();
            for (int j = 0; j < runTimes; j++) {
                obj.invokeMethod("routeList", new Object[]{"chandler", list});
            }
            log.info("groovy invokeMethod :" + (System.currentTimeMillis() - st));
            //加载JavaRoute
            JavaRoute javaRoute = new JavaRoute();
            st = System.currentTimeMillis();
            for (int j = 0; j < runTimes; j++) {
                javaRoute.routeList("chandler", list);
            }
            log.info("javaRoute run :" + (System.currentTimeMillis() - st));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
