package com.chandler.instance.client.example.aspect;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/***
 * Counter 测试
 *
 * @version 1.0.0
 * @author 钱丁君-chandler 2020/2/28 7:19 PM
 * @since 1.8
 */
@Slf4j
public class MicrometerCounterTest {

    private SimpleMeterRegistry registry;

    private Counter counter;

    @BeforeEach
    void init() {
        registry = new SimpleMeterRegistry();
    }

    @Test
    @DisplayName("create function:MeterRegistry couter")
    public void counter1() {
        counter = registry.counter("count_test", "env", "test");
        counter.increment(2.0);
        log.info("Counter add 2.0:{}", counter.count());
        counter.increment();
        log.info("Counter add 1.0:{}", counter.count());
    }

    @Test
    @DisplayName("create function:Counter build")
    public void counter2() {
        counter = Counter.builder("count_build")
                .description("A simple counter")
                .tag("env", "test").register(registry);
        counter.increment();
        log.info("Counter new instance:{}", counter.count());
    }
}