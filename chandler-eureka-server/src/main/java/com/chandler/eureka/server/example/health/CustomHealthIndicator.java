package com.chandler.eureka.server.example.health;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * 自定义健康指标
 *
 * @author 钱丁君-chandler 2019/5/11下午6:07
 * @since 1.8
 */
@Component
public class CustomHealthIndicator extends AbstractHealthIndicator {

    protected void doHealthCheck(Health.Builder builder) throws Exception {
        // Use the builder to build the health status details that should be reported.
        // If you throw an exception, the status will be DOWN with the exception message.

        builder.up()
                .withDetail("app", "Alive")
                .withDetail("author", "chandler");
    }
}
