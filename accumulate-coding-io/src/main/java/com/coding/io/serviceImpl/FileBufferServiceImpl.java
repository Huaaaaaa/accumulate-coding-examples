package com.coding.io.serviceImpl;

import com.coding.io.service.FileBufferService;
import org.springframework.stereotype.Service;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2021/12/23 7:42 上午
 * @description:
 */
@Service
public class FileBufferServiceImpl implements FileBufferService {

    /**
     * 将文件内容写入缓冲区，再从缓冲区读取，使用try-with-resource关闭资源
     *
     * @param filePath
     */
    @Override
    public void writeFromFile(String filePath) {
        try (
                RandomAccessFile raf = new RandomAccessFile(filePath, "rw");
                FileChannel channel = raf.getChannel();
        ) {
            //每次读取50个字节
            ByteBuffer buffer = ByteBuffer.allocate(3);
            int read = channel.read(buffer);
            while (read != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    System.out.println(buffer.getChar());
                }
                buffer.clear();
                read = channel.read(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
