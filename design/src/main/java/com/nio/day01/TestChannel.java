package com.nio.day01;

/**
 * @description: 通道
 * @author: yangjiang
 * @create: 2020-11-11 10:15
 **/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 一、通道：用于源节点与目标节点的连接。在Java NIO中负责缓冲区中数据的传输。
 * * channel本身不存储数据，因此需要配合缓冲区进行传输
 * <p>
 * 二、通道的主要实现类
 * FileChannel
 * SocketChannel
 * ServerSocketChannel
 * <p>
 * 三、获取通道
 * 3.1、java针对支持通道的类提供了getChannel()方法
 * 本地IO:
 * FileInputStream,RandomAccessFile
 * 网络IO:
 * Socket,ServerSocket
 * 3.2、在jdk1.7以后的NIO2针对各个通道提供了静态方法open()
 * <p>
 * 3.3、在jdk1.7 NIO2的Files工具类中的newByteChannel()
 * <p>
 * 四、通道之间的数据传输
 * <p>
 * transferFrom,transferTo
 * <p>
 * 五、分散（Scatter）与聚集（Gather）
 * 分散读取（Scattering Reads）:将通道中的数据分散到多个缓冲区中
 * 聚集写入(Gathering Writes):将多个缓冲区中的数据聚集到通道中
 */

public class TestChannel {
    public static void main(String[] args) {

    }

    public static void test4() throws Exception {
        RandomAccessFile rw = new RandomAccessFile("1.png", "rw");
        //1、获取通道
        FileChannel channel = rw.getChannel();

        //2、分配指定大小的缓冲区
        ByteBuffer buffer1 = ByteBuffer.allocate(100);
        ByteBuffer buffer2 = ByteBuffer.allocate(1024);

        //3、分散读取
        ByteBuffer[] buffers = {buffer1, buffer2};
        channel.read(buffers);

        for (ByteBuffer byteBuffer : buffers) {
            byteBuffer.flip();
        }
        System.out.println(new String(buffers[0].array(), 0, buffers[0].limit()));
        System.out.println("---------------------");
        System.out.println(new String(buffers[1].array(), 0, buffers[1].limit()));

        //4、聚集写入
        RandomAccessFile rw2 = new RandomAccessFile("2.png", "rw");
        FileChannel channel1 = rw2.getChannel();
        channel1.write(buffers);

    }

    public static void test3() throws Exception {
        //通道之间的数据传输(直接缓冲区)
        FileChannel inChannel = FileChannel.open(Paths.get("1.png"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("2.png"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

        inChannel.transferTo(0, inChannel.size(), outChannel);
        //outChannel.transferFrom(inChannel,0,inChannel.size());
        inChannel.close();
        outChannel.close();
    }

    public static void test1() throws Exception {
        //非直接缓冲区利用通道完成文件的复制
        FileInputStream fis = new FileInputStream("1.png");
        FileOutputStream fos = new FileOutputStream("2.png");
        //获取通道
        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();
        //分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //将通道内的数据存入到缓冲区中
        while (inChannel.read(buffer) != -1) {
            buffer.flip();//切换成读取数据的模式
            //将缓冲区中的数据写入到
            outChannel.write(buffer);
            buffer.clear();//清空缓冲区
        }
        outChannel.close();
        inChannel.close();

    }

    public static void test2() throws Exception {
        //直接缓冲区利用通道完成文件的复制
        FileChannel inChannel = FileChannel.open(Paths.get("1.png"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("2.png"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

        //内存映射文件，直接操作物理内存
        MappedByteBuffer map = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer map2 = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        //直接对缓冲区进行数据的读写操作
        byte[] bytes = new byte[map.limit()];
        map.get(bytes);
        map2.put(bytes);
        inChannel.close();
        outChannel.close();
    }
}
