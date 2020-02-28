/*
 * chandler-prometheus
 * 2020/2/28 7:52 PM
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
import io.micrometer.core.instrument.LongTaskTimer;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * 类功能描述
 *
 * @author 钱丁君-chandler 2020/2/28 7:52 PM
 * @version 1.0.0
 * @since 1.8
 */
@Slf4j
public class MicrometerTimerTest {
    private SimpleMeterRegistry registry;
    private Timer timer;

    @BeforeEach
    void init() {
        registry = new SimpleMeterRegistry();
    }

    @Test
    @DisplayName("create timer test")
    public void timer() {
        timer = registry.timer("timer_test", "env", "test");
        timer.record(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long start = System.currentTimeMillis();
        timer.record(() -> {
            try {
                Thread.sleep(1600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        timer.record(Duration.ofMillis(System.currentTimeMillis() - start));
        log.info("Timer max:{}", timer.max(TimeUnit.SECONDS));
        log.info("Timer count:{}", timer.count());
        log.info("Timer total:{}", timer.totalTime(TimeUnit.SECONDS));
    }

    @Test
    @DisplayName("create LongTaskTimer test")
    public void longTask() {
        LongTaskTimer timer = registry.more().longTaskTimer("timer_long_test");
        timer.record(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
