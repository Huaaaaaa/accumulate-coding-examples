package com.accumulate.coding.tool.controller;

import com.accumulate.coding.common.resp.BaseApiResponse;
import com.accumulate.coding.common.resp.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *@ClassName IndexController
 *@Description TODO
 *@Date 2020/9/11  15:42
 */

@RestController
@RequestMapping("/index")
@Api(tags = "欢迎页")
public class IndexController extends BaseController {

    @GetMapping
    @ResponseBody
    @ApiOperation(value = "welcome")
    public BaseApiResponse welcome() {
        return baseApiResponse(new BaseResponse("我们是同志了！！！"), "");
    }
}
