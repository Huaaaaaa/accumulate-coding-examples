package com.accumulate.coding.tool;

import com.accumulate.coding.tool.mapstruct.BasicDesVo;
import com.accumulate.coding.tool.mapstruct.BasicSourceDesMapper;
import com.accumulate.coding.tool.mapstruct.BasicSourceVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class ToolApplicationTests {

    private Logger log = LoggerFactory.getLogger(ToolApplicationTests.class);

    @Autowired
    private BasicSourceDesMapper basicSourceDesMapper;

    @Test
    public void testBasicMapper() {
        BasicSourceVo basicSourceVo = new BasicSourceVo("张三", "男", 20);
        log.info("basicSourceVo={}", basicSourceVo.toString());
        BasicDesVo basicDesVo = basicSourceDesMapper.basicSourceToDes(basicSourceVo);
        log.info("basicDesVo={}", basicDesVo.toString());
        Assert.isTrue(basicSourceVo.getName().equals(basicDesVo.getName()), "name is different");
        Assert.isTrue(basicSourceVo.getSex().equals(basicDesVo.getSex()), "sex is different");
        Assert.isTrue(basicSourceVo.getAge() == (basicDesVo.getAge()), "age is different");

        BasicSourceVo basicSourceVo1 = basicSourceDesMapper.basicDesToSource(basicDesVo);
        log.info("basicSourceVo1={}", basicSourceVo1.toString());
    }

}
