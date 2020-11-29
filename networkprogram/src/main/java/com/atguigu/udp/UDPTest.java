package com.atguigu.udp;

import org.junit.Test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @description: UDP的网络编程, 不需要“握手”。
 * @author: yangjiang
 * @create: 2020-11-29 12:56
 **/
public class UDPTest {


    @Test
    public void sender() throws Exception {
        DatagramSocket socket = new DatagramSocket();
        String str = "我是UDP方式来放发放的数据";
        byte[] data = str.getBytes();
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        DatagramPacket packet = new DatagramPacket(data, 0, data.length, inetAddress, 9090);
        socket.send(packet);
        socket.close();

    }


    @Test
    public void receiver() throws Exception {
        DatagramSocket socket = new DatagramSocket(9090);
        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data, 0, data.length);
        socket.receive(packet);
        data = packet.getData();
        System.out.println(new String(data, 0, data.length));
        socket.close();

    }
}
