/*
 * chandler-config
 * 2020-07-05 18:11
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * Please contact chandler Corporation or visit:
 * https://www.jianshu.com/u/117796446366
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.instance.client.example.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;

import java.util.Properties;

/**
 * 自定义配置中心客户端组件加载监听器
 *
 * @author 钱丁君-chandler 2020-07-05 18:11
 * @version 1.0
 * @since 1.8
 */
@Slf4j
public class CustomPropertySourceListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        log.info("Start read Custom property!");
        ConfigurableEnvironment configurableEnvironment = event.getEnvironment();
        Properties prop = null;//初始化Properties，如果配置来源于服务端，通过请求获取转化成Properties
        configurableEnvironment.getPropertySources().addFirst(new PropertiesPropertySource("chandlerProperty", prop));
        log.info("End read Custom property!");
    }
}
