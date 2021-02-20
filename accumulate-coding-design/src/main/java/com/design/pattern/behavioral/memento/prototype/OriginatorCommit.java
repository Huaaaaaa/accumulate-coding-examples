package com.design.pattern.behavioral.memento.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/20  17:43
 * @Description: Originator角色：原始提交（结合原型模式实现）
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OriginatorCommit implements Serializable,Cloneable {

    private static final long serialVersionUID = 3758277301869925103L;

    private CommitData commitData;

    /**
     * 创建备份
     * @return
     */
    public OriginatorCommit createMemento(){
        return this.clone();
    }

    /**
     * 从指定备份中恢复
     * @param mementoCommitLog
     */
    public void recoveryFromMemento(OriginatorCommit originatorCommit){
        this.commitData = originatorCommit.getCommitData();
    }

    /**
     * 从自身克隆
     * @return
     */
    public OriginatorCommit clone() {
        try {
            return (OriginatorCommit) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
