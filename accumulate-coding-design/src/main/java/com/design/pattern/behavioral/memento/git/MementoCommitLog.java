package com.design.pattern.behavioral.memento.git;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/20  17:46
 * @Description: memento角色：提交日志，即所有提交记录的备份信息
 */
public class MementoCommitLog implements Serializable {

    private static final long serialVersionUID = 2337797208500092062L;

    private CommitData commitData;

    public CommitData getCommitData() {
        return commitData;
    }

    public MementoCommitLog(CommitData commitData) {
        this.commitData = commitData;
    }
}
