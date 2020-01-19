package com.chandler.spring.webflux.example.router;

import com.chandler.spring.webflux.example.entity.Good;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GoodRouterTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void route() {
        String goodString = webTestClient.get()
                .uri("/good").accept(MediaType.TEXT_PLAIN).exchange()
                .expectStatus().isOk().returnResult(String.class).getResponseBody().blockFirst();
        log.info("spring webflux good:{}", goodString);
        Mono<List<Good>> goods=webTestClient.get()
                .uri("/goods").accept(MediaType.APPLICATION_STREAM_JSON).exchange()
                .expectStatus().isOk().expectHeader().contentType(MediaType.APPLICATION_STREAM_JSON)
                .returnResult(Good.class).getResponseBody().collectList();

        goods.subscribe(goodList ->goodList.forEach(good->log.info(good.toString())));
    }

}