/*
 * chandler-spring-test
 * 2019/12/5 2:22 PM
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * Please contact chandler Corporation or visit:
 * https://www.jianshu.com/u/117796446366
 *
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.spring.test.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 类功能描述
 *
 * @author 钱丁君-chandler 2019/12/5 2:22 PM
 * @version 1.0.0
 * @since 1.8
 */
@Slf4j
public class Worker implements Runnable {
    private List<String> outputScraper;
    private CountDownLatch countDownLatch;

    public Worker(List<String> outputScraper, CountDownLatch countDownLatch) {
        this.outputScraper = outputScraper;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        log.info("work do some thing");
        outputScraper.add("Counted down");
        countDownLatch.countDown();
    }
}
