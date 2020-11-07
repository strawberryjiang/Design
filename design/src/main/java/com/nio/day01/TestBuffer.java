package com.nio.day01;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-11-07 20:16
 **/


import java.nio.ByteBuffer;

/**
 * 缓冲区：在java NIO中负责数据的存储。缓冲区就是数组。用于存储不同类型的数据
 * <p>
 * 根据数据类性的不同，提供相应数据类型的缓冲区（除了boolean）
 * <p>
 * ByteBuffer,CharBuffer等
 * <p>
 * 1、上述缓冲区的管理方法几乎一致，通过allocate()来获取缓冲区
 * 2、缓冲区存取数据的两个核心方法
 * put():存入数据到缓冲区中
 * get():获取缓冲区中的数据
 * <p>
 * 3、缓冲区中的四个核心属性
 * capacity:容量，表示缓冲区中最大存储数据的容量，一旦声明就不能改变
 * limit:界限，表示缓冲区中可以操作数据的大小。（limit后面的数据是不能进行读写的）
 * position:位置，表示缓冲区中正在操作数据的位置
 * <p>
 * <p>
 * mark:标记，表示记录当前position的位置。可以通过reset()恢复到mark的位置
 * 一开始默认是limit=capacity
 * 0<=mark<=position <= limit <= capacity
 */
public class TestBuffer {

    public static void main(String[] args) {
        //TestBuffer.test1();
        test2();

    }

    public static void test1() {
        String str = "abcde";
        //1、分配一个指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        System.out.println("-------------allocate--------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        //2、利用put方法存入数据到缓冲区中
        buffer.put(str.getBytes());
        System.out.println("-------------put-----------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        //3、切换成读取数据的模式
        buffer.flip();
        System.out.println("-------------flip-----------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        //4、利用get读取缓冲区中的数据
        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes);
        System.out.println(new String(bytes, 0, bytes.length));
        System.out.println("-------------get-----------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        //5、rewind可重复读数据
        buffer.rewind();
        System.out.println("-------------rewind-----------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        //6、clear:清空缓冲区,但是缓冲区中的数据依然存在，但是处于“被遗忘”状态
        buffer.clear();
        System.out.println("-------------clear-----------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        System.out.println(buffer.get());

    }

    public static void test2() {
        String str = "abcde";
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(str.getBytes());
        buffer.flip();
        byte[] dst = new byte[buffer.limit()];
        buffer.get(dst, 0, 2);
        System.out.println(new String(dst, 0, 2));
        System.out.println(buffer.position());

        //mark标记
        buffer.mark();
        buffer.get(dst, 2, 2);
        System.out.println(new String(dst, 2, 2));
        System.out.println(buffer.position());

        //reset();恢复到mark的位置
        buffer.reset();
        System.out.println(buffer.position());

        if(buffer.hasRemaining()){
            System.out.println(buffer.remaining());//还有正确可以使用的数量
        }

    }
}
