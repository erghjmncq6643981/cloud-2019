/*
 * chandler-prometheus
 * 2020-02-28 20:44
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * Please contact chandler Corporation or visit:
 * https://www.jianshu.com/u/117796446366
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.instance.client.example.aspect;

import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Summary 测试
 *
 * @author 钱丁君-chandler 2020-02-28 20:44
 * @since 1.8
 */
@Slf4j
public class MicrometerSummaryTest {
    private SimpleMeterRegistry registry;

    @BeforeEach
    void init() {
        registry = new SimpleMeterRegistry();
    }

    @Test
    @DisplayName("MeterRegistry summary create ")
    public void summary() {
        DistributionSummary summary = registry.summary("summary_test", "env", "test");
        summary.record(1);
        summary.record(1.3);
        summary.record(2.4);
        summary.record(3.5);
        summary.record(4.1);
        log.info("Timer max:{}", summary.max());
        log.info("Timer count:{}", summary.count());
        log.info("Timer total:{}", summary.totalAmount());
    }
}
