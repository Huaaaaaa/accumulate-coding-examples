package com.coding.web.io;

import com.coding.io.service.FileBufferService;
import com.coding.web.AccumulateCoding;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = AccumulateCoding.class)
class BufferTests {

    @Autowired
    private FileBufferService fileBufferService;

    private String filePath = "/tmp/accumulate/testFiles/buffer.txt";

    @Test
    void testWriteToBuffer() {
        fileBufferService.writeFromFile(filePath);
    }

}
