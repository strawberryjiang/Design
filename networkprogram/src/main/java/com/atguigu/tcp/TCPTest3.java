package com.atguigu.tcp;


import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:实现TCP的网络编程
 * @author: yangjiang
 * @create: 2020-11-29 10:18
 **/


/**
 * 客户端发放文件给服务端，服务端将文件保存在本地，并且发放成功给客户端
 */
public class TCPTest3 {


    @Test
    public void client() throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream(new File("D:\\AAAAAA\\aa.txt"));
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            os.write(bytes, 0, len);
        }
        //因为read方法是阻塞的
        socket.shutdownOutput();
        //接受来自服务器端发送的消息
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] bytes2 = new byte[5];
        while ((len = is.read(bytes2)) != -1) {
            bos.write(bytes, 0, len);
        }
        System.out.println(bos.toString());
        bos.close();
        os.close();
        fis.close();
        socket.close();
    }


    @Test
    public void server() throws IOException {
        //1、创建一个serverSocket并且指明自己的端口号
        ServerSocket serverSocket = new ServerSocket(9090);
        //2、调用accept方法，表示接受来自客户端的socket
        Socket socket = serverSocket.accept();
        //3、获取输入流
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("D:\\AAAAAA\\aa1.txt"));
        //4、读取输入流
        byte[] bytes = new byte[1000];
        int len;
        while ((len = is.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }
        //5、服务器端给客户端反馈
        OutputStream os = socket.getOutputStream();
        os.write("你好，美女，照片我已经收到".getBytes());
        os.close();
        is.close();
        fos.close();
        socket.close();
        serverSocket.close();


    }
}
