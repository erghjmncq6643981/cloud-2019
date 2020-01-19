/*
 * chandler-spring-webflux
 * 2020/1/19 11:43 AM
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * Please contact chandler Corporation or visit:
 * https://www.jianshu.com/u/117796446366
 *
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.spring.webflux.example.handler;

import com.chandler.spring.webflux.example.entity.Good;
import com.chandler.spring.webflux.example.generator.GoodGenerator;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_STREAM_JSON;
import static org.springframework.http.MediaType.TEXT_PLAIN;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * 类功能描述
 *
 * @author 钱丁君-chandler 2020/1/19 11:43 AM
 * @version 1.0.0
 * @since 1.8
 */
@Component
@Configuration
public class GoodHandler {
    private final Flux<Good> goods;

    public GoodHandler(GoodGenerator goodGenerator) {
        this.goods = goodGenerator.findGoods();
    }

    public Mono<ServerResponse> hello(ServerRequest request) {
        return ok().contentType(TEXT_PLAIN)
                .body(BodyInserters.fromObject("Hello Spring!"));
    }

    public Mono<ServerResponse> echo(ServerRequest request) {
        return ok().contentType(APPLICATION_STREAM_JSON)
                .body(this.goods, Good.class);
    }
}
