package com.accumulate.coding.basic.io.nio;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2022/1/9 4:15 下午
 * @description: 操作直接内存
 * MapByteBuffer：可以直接在堆外内存中修改文件，不需要操作系统拷贝
 */
public class NioMapByteBuffer {

    public static void main(String[] args) throws Exception {
        RandomAccessFile raf = new RandomAccessFile("static/file/map.txt", "rw");
        //获取通道
        FileChannel channel = raf.getChannel();
        /*
         * mode: 通道模式
         * position：直接修改的开始位置
         * size：映射到内存的大小，即能修改的个数
         */
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        map.put(0, (byte) 'H');
        map.put(3, (byte) 9);
        raf.close();
        System.out.println("修改成功");

    }
}
