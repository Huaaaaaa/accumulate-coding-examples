package com.accumulate.coding.basic;

import com.accumulate.coding.basic.res.ShiftRes;
import com.accumulate.coding.basic.shift.ShiftUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class AccumulateCodingBasicApplicationTests {

    @Test
    void testShift() {
        int data = 1;
        ShiftRes leftShiftRes = ShiftUtil.shift(data, 1, "left");
        ShiftRes rightShiftRes = ShiftUtil.shift(data, 1, "right");
        ShiftRes unRightShiftRes = ShiftUtil.shift(data, 1, "unRight");
        log.info("leftShiftRes={}", leftShiftRes.toString());
        log.info("rightShiftRes={}", rightShiftRes.toString());
        log.info("unRightShiftRes={}", unRightShiftRes.toString());
    }

}
