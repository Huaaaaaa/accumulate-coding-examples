package com.accumulate.coding.tool.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *@ClassName GenerateCodeReq
 *@User huayingcao2
 *@Description TODO
 *@Date 2020/9/11  14:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "生成代码请求参数")
public class GenerateCodeReq {

    /**
     * 模块名
     */
    @ApiModelProperty(value = "模块名", example = "order")
    private String moduleName;

    /**
     * 包名
     */
    @ApiModelProperty(value = "生成代码所在的包名", example = "com.accumulate.coding.tool.code")
    private String packageName;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GenerateCodeReq{");
        sb.append("moduleName='").append(moduleName).append("'");
        sb.append(",packageName='").append(packageName).append("'");
        sb.append("}");
        return sb.toString();
    }
}
