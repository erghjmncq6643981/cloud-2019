/*
 * chandler-spring-test
 * 3/16/21 10:22 PM
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * Please contact chandler Corporation or visit:
 * https://www.jianshu.com/u/117796446366
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.spring.test.concurrent;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * Exchanger测试
 *
 * @author 钱丁君-chandler 3/16/21 10:22 PM
 * @version 1.0
 * @since 1.8
 */
public class ExchangerTest {
  static class ThreadA extends Thread {
    private Exchanger<Integer> exchanger;

    ThreadA(Exchanger<Integer> exchanger) {
      super("ThreadA");
      this.exchanger = exchanger;
    }

    @Override
    public void run() {
      for (int i = 1; i < 5; i++) {
        try {
          System.out.println(getName() + " 交换值:" + exchanger.exchange(i));
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  static class ThreadB extends Thread {
    private Exchanger<Integer> exchanger;

    ThreadB(Exchanger<Integer> exchanger) {
      super("ThreadB");
      this.exchanger = exchanger;
    }

    @Override
    public void run() {
      while (true) {
        try {
          System.out.println(getName() + "交换值:" + exchanger.exchange(0));
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public static void main(String[] args) {
    Exchanger<Integer> exchanger = new Exchanger<>();
    new ThreadA(exchanger).start();
    new ThreadB(exchanger).start();
    try {
      TimeUnit.SECONDS.sleep(7);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.exit(-1);
  }
}
