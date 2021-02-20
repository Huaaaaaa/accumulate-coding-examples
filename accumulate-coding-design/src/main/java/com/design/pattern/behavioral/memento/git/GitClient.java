package com.design.pattern.behavioral.memento.git;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/20  18:12
 * @Description: 模拟git提交及撤销
 */
public class GitClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CaretakerCommitLog caretakerCommitLog = new CaretakerCommitLog();
        OriginatorCommit originatorCommit = new OriginatorCommit();
        System.out.println("请输入命令：");
        while (scanner.hasNext()) {
            String next = scanner.next();
            if (next.equals("git-logs")) {
                List<MementoCommitLog> currentBranchCommitLogs = caretakerCommitLog.getCurrentBranchCommitLogs();
                if (CollectionUtils.isEmpty(currentBranchCommitLogs)) {
                    System.out.println("您尚未提交，请提交完后重试");
                    continue;
                }
                currentBranchCommitLogs.forEach(mementoCommitLog -> System.out.println(mementoCommitLog.getCommitData().toString()));
            } else if (next.contains("git-rollback")) {
                String commitId = next.substring(next.indexOf("git-rollback:") + 13, next.length());
                MementoCommitLog currentBranchCommitLog = caretakerCommitLog.getCurrentBranchCommitLog(commitId);
                if (currentBranchCommitLog == null) {
                    System.out.println("当前commit不存在，请重试");
                    continue;
                }
                originatorCommit.recoveryFromMemento(currentBranchCommitLog);
                System.out.println("rollback to:\r\n" + originatorCommit.getCommitData().toString());
            } else if (next.contains("git-commit")) {
                String content = next.substring(next.indexOf("git-commit:") + 11, next.length());
                //提交内容格式：git-commit:message,data
                String[] logs = content.split(",");
                CommitData commitData = new CommitData(generateCommitId(), logs[0], logs[1]);
                //提交
                originatorCommit = new OriginatorCommit(commitData);
                //备份提交
                MementoCommitLog memento = originatorCommit.createMemento();
                //管理备份
                caretakerCommitLog.addCurrentBranchCommitLog(memento);
            } else {
                System.out.println("当前命令不支持，请重新输入");
            }
        }
    }

    private static String generateCommitId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
