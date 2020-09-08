package com.accumulate.coding.common.error;

import com.accumulate.coding.common.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

/**
 * @ClassName Error
 * @Description TODO
 * @Date 2020/8/30  22:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseError implements Serializable {


    private static final long serialVersionUID = -6949054721508383105L;

    private Integer code;

    private String message;

    private Map<String, Object> details;


    public static BaseError error(ResultCode resultCode) {
        return new BaseError(resultCode.getCode(), resultCode.getMessage(), null);
    }
}
