/*
 * chandler-spring-test
 * 2019/9/5 上午10:58
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

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 内存池设置
 *
 * @author 钱丁君-chandler 2019/9/5上午10:58
 * @since 1.8
 */
public class ByteBufTest {
    private static int port=18006;

    public static void main(String[] args) {
        EventLoopGroup bossGroup=new NioEventLoopGroup();   //用来接收进来的连接
        EventLoopGroup workerGroup=new NioEventLoopGroup(); //用来处理已经被接收的连接

        ServerBootstrap server=new ServerBootstrap();

        System.out.println("准备运行端口：" + port);
        try {
            server.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,512)
                    .childOption(ChannelOption.TCP_NODELAY,true)
                    //  Boss线程内存池配置
                    .option(ChannelOption.ALLOCATOR,PooledByteBufAllocator.DEFAULT)
                    //  Work线程内存池配置
                    .childOption(ChannelOption.ALLOCATOR,PooledByteBufAllocator.DEFAULT);

            ChannelFuture future=server.bind(port).sync();
        }catch (InterruptedException e){
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
            e.printStackTrace();
        }
    }
}
