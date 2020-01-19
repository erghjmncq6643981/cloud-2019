/*
 * chandler-spring-webflux
 * 2020/1/19 12:01 PM
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * Please contact chandler Corporation or visit:
 * https://www.jianshu.com/u/117796446366
 *
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.spring.webflux.example.router;

import com.chandler.spring.webflux.example.handler.GoodHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_STREAM_JSON;
import static org.springframework.http.MediaType.TEXT_PLAIN;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

/**
 * 路由器
 *
 * @author 钱丁君-chandler 2020/1/19 12:01 PM
 * @version 1.0.0
 * @since 1.8
 */
@Configuration
public class GoodRouter {
    @Bean
    public RouterFunction<ServerResponse> route(GoodHandler goodHandler) {
        return RouterFunctions
                .route(GET("/good")
                        .and(accept(TEXT_PLAIN)), goodHandler::hello)
                .andRoute(GET("/goods")
                        .and(accept(APPLICATION_STREAM_JSON)), goodHandler::echo);
    }
}
