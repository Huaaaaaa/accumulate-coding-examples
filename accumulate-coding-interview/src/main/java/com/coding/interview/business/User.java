package com.coding.interview.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: huayingcao
 * @createTime: 2021/12/12 8:23 下午
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private String userId;

    private String userName;

    private String nickName;
}
