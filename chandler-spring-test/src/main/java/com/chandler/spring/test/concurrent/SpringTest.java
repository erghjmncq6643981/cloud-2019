/*
 * chandler-spring-test
 * 2019/11/27 7:18 PM
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
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;


/**
 * 类功能描述
 *
 * @author 钱丁君-chandler 2019/11/27 7:18 PM
 * @version 1.0.0
 * @since 1.8
 */
@Slf4j
public class SpringTest {

    public static void main(String[] args) {
        SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();
        ListenableFuture<String> future1 = taskExecutor.submitListenable(() -> {
            throw new Exception("error test");
//            return "task done";
        });
        ListenableFuture<String> future2 = taskExecutor.submitListenable(() -> {
//            throw new Exception("error test");
            return "task done";
        });
        ListenableFutureCallback callback = new ListenableFutureCallback<String>() {

            @Override
            public void onSuccess(String result) {
                log.info("Futures.addCallback 能带返回值：{}", result);
            }

            @Override
            public void onFailure(Throwable ex) {
                log.warn("出错,业务回滚或补偿");
            }
        };

        future1.addCallback(callback);
        future2.addCallback(callback);
    }

}
