package com.accumulate.coding.common.resp;

import com.accumulate.coding.common.error.BaseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName ToolResponse
 * @Description TODO
 * @Date 2020/8/30  22:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseApiResponse<T> implements Serializable {

    private static final long serialVersionUID = 5606458175381737652L;

    private String requestId;

    private T data;

    private BaseError error;
}
