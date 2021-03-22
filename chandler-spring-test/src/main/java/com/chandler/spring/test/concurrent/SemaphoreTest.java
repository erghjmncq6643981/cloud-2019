/*
 * chandler-spring-test
 * 3/16/21 9:58 PM
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * Please contact chandler Corporation or visit:
 * https://www.jianshu.com/u/117796446366
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.spring.test.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore测试
 *
 * @author 钱丁君-chandler 3/16/21 9:58 PM
 * @version 1.0
 * @since 1.8
 */
public class SemaphoreTest {
  public static void main(String[] args) {
    ExecutorService service = Executors.newCachedThreadPool();
    Semaphore semaphore = new Semaphore(3); // 创建Semaphore，许可3个线程同时运行
    for (int i = 0; i < 10; i++) {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      service.submit(
          () -> {
            try {
              // 获取许可，如果能够获取，继续向下执行；如果不能，就被阻塞；
              semaphore.acquire();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
            System.out.println(
                "线程"
                    + Thread.currentThread().getName()
                    + "进入，当前已有"
                    + (3 - semaphore.availablePermits())
                    + "个并发");
            try {
              Thread.sleep((long) (Math.random() * 10000));
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
            System.out.println("线程" + Thread.currentThread().getName() + "即将离开");
            // 释放许可
            semaphore.release();
            System.out.println(
                "线程"
                    + Thread.currentThread().getName()
                    + "已离开，当前已有"
                    + (3 - semaphore.availablePermits())
                    + "个并发");
          });
    }
  }
}
