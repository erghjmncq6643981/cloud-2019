/*
 * chandler-spring-test
 * 2019/11/27 6:08 PM
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

import com.google.common.util.concurrent.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.*;

/**
 * 类功能描述
 *
 * @author 钱丁君-chandler 2019/11/27 6:08 PM
 * @version 1.0.0
 * @since 1.8
 */
@Slf4j
public class GuavaTest {

    public static void main(String[] args) {
        //真正干活的线程池
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                3,
                5,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100),
                new CustomizableThreadFactory("demo"),
                new ThreadPoolExecutor.DiscardPolicy());
        //guava的接口ListeningExecutorService继承了jdk原生ExecutorService接口，重写了submit方法，修改返回值类型为ListenableFuture
        ListeningExecutorService listeningExecutor = MoreExecutors.listeningDecorator(poolExecutor);

        //获得一个随着jvm关闭而关闭的线程池，通过Runtime.getRuntime().addShutdownHook(hook)实现
        //修改ThreadFactory为创建守护线程，默认jvm关闭时最多等待120秒关闭线程池，重载方法可以设置时间
        ExecutorService newPoolExecutor = MoreExecutors.getExitingExecutorService(poolExecutor);

        //只增加关闭线程池的钩子，不改变ThreadFactory
        MoreExecutors.addDelayedShutdownHook(poolExecutor, 120, TimeUnit.SECONDS);


        // 回调实现
        FutureCallback callback = new FutureCallback<String>() {

            @Override
            public void onSuccess(String result) {
                log.info("Futures.addCallback 能带返回值：{}", result);
            }

            @Override
            public void onFailure(Throwable ex) {
                log.warn("{} 出错,业务回滚或补偿",ex);
            }
        };
        //像线程池提交任务，并得到ListenableFuture
        ListenableFuture<String> errorListenableFuture = listeningExecutor.submit(() -> {
            return "task done";
        });
        ListenableFuture<String> successListenableFuture = listeningExecutor.submit(() -> {
            return "success";
        });
        //可以通过addListener对listenableFuture注册回调，但是通常使用Futures中的工具方法
        Futures.addCallback(errorListenableFuture, callback,listeningExecutor);

        Futures.addCallback(successListenableFuture, callback,listeningExecutor);
    }
}
