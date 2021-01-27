package com.accumulate.coding.common.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * Author: Huaaaaaa
 * DateTime: 2021/1/27  11:40
 * Description:  redis请求
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class MiddleSetRedisReq<T> implements Serializable {


    private static final long serialVersionUID = -5022296593995481110L;

    private String key;

    private T value;

}
