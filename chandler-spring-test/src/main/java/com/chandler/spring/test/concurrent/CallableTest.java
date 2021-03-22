/*
 * chandler-spring-test
 * 3/16/21 11:18 PM
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * Please contact chandler Corporation or visit:
 * https://www.jianshu.com/u/117796446366
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.spring.test.concurrent;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable和Future测试
 *
 * @author 钱丁君-chandler 3/16/21 11:18 PM
 * @version 1.0
 * @since 1.8
 */
public class CallableTest {

  public static void main(String[] args) {
    // FutureTask是Future的实现类
    FutureTask task =
        new FutureTask(
            () -> { // Callable的实现
              Random generator = new Random();
              Integer randomNumber = generator.nextInt(10);
              return randomNumber;
            });
    task.run();
    try {
      // 获取返回值
      System.out.println(task.get());
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
  }
}
