package com.accumulate.coding.tool.controller;

/**
 *@ClassName ToolController
 *@Description TODO
 *@Date 2020/9/11  14:51
 */

import com.accumulate.coding.common.resp.BaseApiResponse;
import com.accumulate.coding.common.resp.BaseResponse;
import com.accumulate.coding.tool.common.CodeUtil;
import com.accumulate.coding.tool.request.GenerateCodeReq;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tool")
@Api(tags = "工具管理")
public class ToolController extends BaseController {

    @Autowired
    private CodeUtil codeUtil;

    @PostMapping("/generateCode")
    @ResponseBody
    @ApiOperation(value = "自动生成代码")
    public BaseApiResponse<Boolean> generateCode(@RequestBody GenerateCodeReq req) {
        AutoGenerator autoGenerator = codeUtil.getAutoGenerator(req.getModuleName(), req.getPackageName());
        autoGenerator.execute();
        return baseApiResponse(new BaseResponse(true), "");
    }
}
