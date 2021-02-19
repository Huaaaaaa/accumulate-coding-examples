package com.accumulate.coding.common.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/1/27  16:14
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MiddleGetRedisReq implements Serializable {


    private static final long serialVersionUID = -4369728416333636275L;

    /**
     * key
     */
    private String key;

    /**
     * type:string-String;list-List;set-Set;hash-Hash;
     */
    private String type;
}
