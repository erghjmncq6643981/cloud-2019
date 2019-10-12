/*
 * chandler-spring-test
 * 2019/9/5 上午11:24
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * Please contact chandler Corporation or visit:
 * https://www.jianshu.com/u/117796446366
 *
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.spring.test.netty;

import java.util.Date;

/**
 * 类功能描述
 *
 * @author 钱丁君-chandler 2019/9/5上午11:24
 * @since 1.8
 */
public class MessageHead {
    private int headData = 0X76;//协议开始标志
    private int length;//包的长度
    private String token;
    private Date createDate;

    public int getHeadData() {
        return headData;
    }

    public void setHeadData(int headData) {
        this.headData = headData;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "MessageHead{" +
                "headData=" + headData +
                ", length=" + length +
                ", token='" + token + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
