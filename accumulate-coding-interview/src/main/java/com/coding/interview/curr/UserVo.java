package com.coding.interview.curr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2021/12/31 12:00 下午
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserVo implements Serializable {
    private static final long serialVersionUID = 7363740645897230675L;

    private String userId;

    private String userName;


}
