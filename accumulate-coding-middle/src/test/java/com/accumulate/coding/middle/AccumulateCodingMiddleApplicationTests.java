package com.accumulate.coding.middle;

import com.accumulate.coding.middle.api.BaiDuTranslateResult;
import com.accumulate.coding.middle.api.IBaiDuApi;
import com.zaxxer.hikari.util.ConcurrentBag;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;

@SpringBootTest
@Slf4j
class AccumulateCodingMiddleApplicationTests {

    @Autowired
    private IBaiDuApi iBaiDuApi;

    @Test
    void testTranslate() {
        String res = null;
        try {
            res = iBaiDuApi.translate("en", "zh", "hello");
            log.info("testTranslate res={}", res);
        } catch (UnsupportedEncodingException e) {
            log.info("e={}", e.getMessage());
        }
    }

}
