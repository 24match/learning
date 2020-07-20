package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author
 * @Date 2019/10/10 11:10
 * @Version
 */
public class TimeServer {
    public static void main(String[] args) {
        int port = 2424;
        new TimeServer().bind(port);
    }

    /**
     * 配置服务端的NIO线程池,用于网络事件处理,实际上他们是Reactor线程组
     * bossGroup 用于服务端接受客户端连接,
     * workerGroup 用于SocketChanel网络读写
     * @param port
     */
    private void bind(int port) {

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            //ServerBootstrap 是 Netty 用于启动 NIO 服务端的辅助启动类，用于降低开发难度
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,1024)
                    .childHandler(new ChildChannelHandler());

            ChannelFuture f = serverBootstrap.bind(port).sync();

            System.out.println(Thread.currentThread().getName()+",服务器开始监听端口,等待客户端连接.....");
            //下面将进行阻塞
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class ChildChannelHandler extends ChannelInitializer<SocketChannel> {
        @Override
        protected void initChannel(SocketChannel socketChannel) {
            socketChannel.pipeline().addLast(new TimeServerHandler());
        }
    }
}
