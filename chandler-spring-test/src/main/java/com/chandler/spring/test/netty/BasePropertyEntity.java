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

import java.util.Arrays;

/**
 * 类功能描述
 *
 * @author 钱丁君-chandler 2019/9/5上午11:24
 * @since 1.8
 */

public class BasePropertyEntity {
    // 协议头
    private MessageHead head;

    // 内容
    private byte[] content;

    public BasePropertyEntity(MessageHead head, byte[] content) {
        this.head = head;
        this.content = content;
    }

    public MessageHead getHead() {
        return head;
    }

    public void setHead(MessageHead head) {
        this.head = head;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "BasePropertyEntity{" +
                "head=" + head +
                ", content=" + Arrays.toString(content) +
                '}';
    }
}
