package com.design.pattern.behavioral.memento.git;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.google.common.base.Preconditions;

import java.util.*;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/20  17:52
 * @Description: 备份管理角色caretaker
 */
public class CaretakerCommitLog {

    //管理一个分支的一次提价：针对只有两种状态的情况，不适用git
    private MementoCommitLog mementoCommitLog;
    //管理一个分支的多个提交
    private List<MementoCommitLog> mementoCommitLogs = new ArrayList<>();
    //管理多个分支的多个提交备份
    private Map<String, List<MementoCommitLog>> branchCommitLogs = new HashMap<>();

    /**
     * 当前分支的提交记录
     *
     * @param mementoCommitLog
     */
    public void addCurrentBranchCommitLog(MementoCommitLog mementoCommitLog) {
        mementoCommitLogs.add(mementoCommitLog);
    }

    /**
     * 当前分支的某个提价记录
     *
     * @param commitId
     * @return
     */
    public MementoCommitLog getCurrentBranchCommitLog(String commitId) {
        return mementoCommitLogs.stream().filter(log -> commitId.equals(log.getCommitData().getCommitId())).findFirst().orElse(null);
    }

    /**
     * 获取当前分支的所有提交记录
     *
     * @return
     */
    public List<MementoCommitLog> getCurrentBranchCommitLogs() {
        return mementoCommitLogs;
    }

    /**
     * 指定分支的提交记录
     *
     * @param mementoCommitLog
     */
    public void addMarkBranchCommitLog(String branchName, MementoCommitLog mementoCommitLog) {
        List<MementoCommitLog> logs = branchCommitLogs.get(branchName);
        if (CollectionUtils.isEmpty(logs)) {
            logs = new ArrayList<>();
        }
        logs.add(mementoCommitLog);
        branchCommitLogs.put(branchName, logs);
    }

    /**
     * 指定分支的某个提交记录
     *
     * @param branchName
     * @param commitId
     * @return
     */
    public MementoCommitLog getMarkBranchCommitLog(String branchName, String commitId) {
        Preconditions.checkNotNull(branchCommitLogs.get(branchName), "分支" + branchName + "不存在");
        List<MementoCommitLog> mementoCommitLogs = branchCommitLogs.get(branchName);
        return mementoCommitLogs.stream().filter(log -> commitId.equals(log.getCommitData().getCommitId())).findFirst().orElse(null);
    }

    /**
     * 获取指定分支的所有提交记录
     *
     * @return
     */
    public List<MementoCommitLog> getMarkBranchCommitLogs(String branchName) {
        Preconditions.checkNotNull(branchCommitLogs.get(branchName), "分支" + branchName + "不存在");
        return branchCommitLogs.get(branchName);
    }
}
