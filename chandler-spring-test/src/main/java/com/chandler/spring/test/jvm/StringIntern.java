/*
 * chandler-spring-test
 * 2020-11-10 23:00
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * Please contact chandler Corporation or visit:
 * https://www.jianshu.com/u/117796446366
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.spring.test.jvm;

/**
 * 类功能描述
 *
 * @author 钱丁君-chandler 2020-11-10 23:00
 * @version 1.0
 * @since 1.8
 */
public class StringIntern {
  public static void main(String[] args) {
    String str1 = new StringBuilder("计算机").append("软件").toString();
    System.out.println(str1.intern() == str1);

    String str2 = new StringBuilder("ja").append("va").toString();
    System.out.println(str2.intern() == str2);
  }
}
