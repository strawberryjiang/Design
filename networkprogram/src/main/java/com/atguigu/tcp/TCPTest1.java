package com.atguigu.tcp;


import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:实现TCP的网络编程
 * @author: yangjiang
 * @create: 2020-11-29 10:18
 **/


/**
 * 客户端发放信息给服务器，服务端将数据显示在控制台上
 */
public class TCPTest1 {


    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        try {
            String HostIP = "127.0.0.1";
            InetAddress inetAddress = InetAddress.getByName(HostIP);
            //1、创建socket对象，指明服务器IP与端口号
            socket = new Socket(inetAddress, 8899);
            //2、获取一个输出流，用于输出数据
            os = socket.getOutputStream();
            //3、写出数据
            os.write("你好，我是客户端".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }


    }


    @Test
    public void server() throws IOException {
        //1、创建一个serverSocket并且指明自己的端口号
        ServerSocket serverSocket = new ServerSocket(8899);
        //2、调用accept方法，表示接受来自客户端的socket
        Socket socket = serverSocket.accept();
        //3、获取输入流
        InputStream is = socket.getInputStream();
        //4、读取输入流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bytes = new byte[5];
        int len;
        while ((len = is.read(bytes)) != -1) {
            baos.write(bytes, 0, len);
        }
        System.out.println(baos.toString());
        System.out.println(socket.getInetAddress());
        baos.close();
        is.close();
        socket.close();
        serverSocket.close();


    }
}
