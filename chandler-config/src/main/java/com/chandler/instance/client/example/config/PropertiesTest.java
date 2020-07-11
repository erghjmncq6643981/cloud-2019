/*
 * chandler-config
 * 2020-07-05 15:08
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * Please contact chandler Corporation or visit:
 * https://www.jianshu.com/u/117796446366
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.instance.client.example.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * java properties测试
 *
 * @author 钱丁君-chandler 2020-07-05 15:08
 * @version 1.0
 * @since 1.8
 */
public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties pps = new Properties();
        pps.load(new FileInputStream("/Users/qiandingjun/resource/git-repository/test/test.properties"));
        pps.list(System.out);
    }
}
