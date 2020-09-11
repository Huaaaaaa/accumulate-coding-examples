package com.accumulate.coding.test.util;

import com.accumulate.coding.tool.common.CodeUtil;
import com.accumulate.coding.tool.test.base.BaseTest;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName UtilTest
 * @Description TODO
 * @Date 2020/9/10  18:04
 */
public class UtilTest extends BaseTest {

    @Autowired
    private CodeUtil codeUtil;

    @Test
    public void testCodeUtil() {
        String project = "accumulate-coding-tool";
        String packagePath = "com.accumulate.coding.tool.mapper";
        AutoGenerator autoGenerator = codeUtil.getAutoGenerator(project, packagePath);
        autoGenerator.execute();
    }

}
