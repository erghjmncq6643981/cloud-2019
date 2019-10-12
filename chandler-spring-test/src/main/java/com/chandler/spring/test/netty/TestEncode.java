/*
 * chandler-spring-test
 * 2019/9/5 上午11:18
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

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 编码器
 *
 * @author 钱丁君-chandler 2019/9/5上午11:18
 * @since 1.8
 */
public class TestEncode extends MessageToByteEncoder<BasePropertyEntity> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, BasePropertyEntity basePropertyEntity, ByteBuf byteBuf) throws Exception {
        int length = 10;
        // 在此使用堆外缓冲区是为了将数据更快速的写入内核中，如果使用堆缓冲区会多一次堆内存向内核进行内存拷贝，这样会降低性能。
        ByteBuf buffer = PooledByteBufAllocator.DEFAULT.directBuffer(length);

        try {
            byte[] context = new byte[length];
            buffer.writeBytes(context);
            byteBuf.writeBytes(buffer);
        } finally {
            // 必须释放自己申请的内存池缓冲区，否则会内存泄漏。
            // byteBuf 是Netty自身Socket发送的ByteBuf系统会自动释放，用户不需要做二次释放
            buffer.release();
        }
    }
}
