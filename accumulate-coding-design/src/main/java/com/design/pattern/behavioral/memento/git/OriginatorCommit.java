package com.design.pattern.behavioral.memento.git;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/20  17:43
 * @Description: Originator角色：原始提交
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OriginatorCommit implements Serializable {

    private static final long serialVersionUID = 3758277301869925103L;

    private CommitData commitData;

    /**
     * 创建备份
     * @return
     */
    public MementoCommitLog createMemento(){
        return new MementoCommitLog(commitData);
    }

    /**
     * 从指定备份中恢复
     * @param mementoCommitLog
     */
    public void recoveryFromMemento(MementoCommitLog mementoCommitLog){
        this.commitData = mementoCommitLog.getCommitData();
    }


}
