/*
 * chandler-prometheus
 * 2020/2/28 7:24 PM
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * Please contact chandler Corporation or visit:
 * https://www.jianshu.com/u/117796446366
 *
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.instance.client.example.aspect;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Gauge 测试
 *
 * @author 钱丁君-chandler 2020/2/28 7:24 PM
 * @version 1.0.0
 * @since 1.8
 */
@Slf4j
public class MicrometerGaugeTest {
    private SimpleMeterRegistry registry;

    @BeforeEach
    void init() {
        registry = new SimpleMeterRegistry();
    }

    @Test
    @DisplayName("MeterRegistry gauge create value ")
    public void value() {
        AtomicInteger value = registry.gauge("gauge_value_test", new AtomicInteger(0));
        value.set(1);
        log.info("MeterRegistry Gauge increment, value:{}", value.incrementAndGet());
        log.info("MeterRegistry Gauge decrement, value:{}", value.decrementAndGet());
    }

    @Test
    @DisplayName("MeterRegistry gauge create values")
    public void list() {
        List<String> list = registry.gaugeCollectionSize("gauge_list_test", Collections.emptyList(), new ArrayList<>());
        list.add("a");
        list.add("b");
        log.info("MeterRegistry Gauge list:{}", list);
        Map<String, String> map = registry.gaugeMapSize("gauge_map_test", Collections.emptyList(), new HashMap<>());
        map.put("a", "b");
        log.info("MeterRegistry Gauge map:{}", map);
    }

    @Test
    @DisplayName("create function:Gauge build")
    public void map() {
        Gauge gauge = Gauge.builder("gauge_build_test", this, MicrometerGaugeTest::getValue)
                .description("a simple gauge")
                .tag("tag1", "a")
                .register(registry);
        log.info("Gauge build, value:{}", gauge.value());
    }

    private double getValue() {
        return ThreadLocalRandom.current().nextDouble();
    }
}
