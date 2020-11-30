package com.nio.day02;

/**
 * @description: 非阻塞式NIO的测试
 * @author: yangjiang
 * @create: 2020-11-30 17:54
 **/


import org.junit.Test;

import javax.print.DocFlavor;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * 使用NIO通信的三个核心概念
 * 1、通道Channel:负责连接
 * java.nio.channels.Channel
 * <p>
 * 2、缓冲区buffer:负责数据的存取
 * 3、选择器selector:是SelectorChannel多路复用器,用于监控SelectorChannel的IO情况
 */
public class TestNoBlockingNIO {


    @Test
    public void client() throws Exception {
        //1、获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

        //2、切换成非阻塞模式
        socketChannel.configureBlocking(false);

        //3、分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //4、发送数据给服务端
        buffer.put(new Date().toString().getBytes());
        buffer.flip();
        socketChannel.write(buffer);
        buffer.clear();

        //5、关闭通道
        socketChannel.close();


    }

    @Test
    public void server() throws Exception {
        //1、获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //2、切换非阻塞通道
        serverSocketChannel.configureBlocking(false);

        //3、绑定连接
        serverSocketChannel.bind(new InetSocketAddress(9898));

        //4、获取通道
        Selector selector = Selector.open();

        //5、将通道注册到选择器上，并且指定"监听接收事件"
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //6、轮询式的获取选择器上"已经准备就绪"的事件
        while (selector.select() > 0) {
            //7、获取当前选择器中所有注册的"选择键(已就绪的监听事件)"
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            while (iterator.hasNext()) {
                //8、获取准备就绪的事件
                SelectionKey selectionKey = iterator.next();

                //9、判断具体是什么事件准备就绪
                if (selectionKey.isAcceptable()) {
                    //10、若"接收就绪"获取客户端的连接
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    //11、切换非阻塞模式
                    socketChannel.configureBlocking(false);
                    //12、将该通道注册到选择器上
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    //13、获取当前选择器上"读就绪"状态的通道
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    //14、读取数据
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int len;
                    while ((len = socketChannel.read(buffer)) > 0) {
                        buffer.flip();
                        System.out.println(new String(buffer.array(), 0, len));
                        buffer.clear();
                    }
                }

            }
            iterator.remove();

        }


    }
}
