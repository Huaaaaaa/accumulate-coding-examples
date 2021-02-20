package com.design.pattern.behavioral.memento.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/20  17:47
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommitData implements Serializable {

    private static final long serialVersionUID = -902138611457473521L;

    /**
     * 提交id
     */
    private String commitId;

    /**
     * 提交信息
     */
    private String message;

    /**
     * 提交的数据
     */
    private Object data;
}
