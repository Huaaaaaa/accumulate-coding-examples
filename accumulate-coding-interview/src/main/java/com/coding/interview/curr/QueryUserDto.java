package com.coding.interview.curr;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2021/12/31 11:58 上午
 * @description: 查询对象
 */
public class QueryUserDto implements Serializable {

    private static final long serialVersionUID = -5119232050797741987L;
    private String userId;

    private CompletableFuture<UserVo> completableFuture;

    public QueryUserDto() {
    }

    public QueryUserDto(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public CompletableFuture<UserVo> getCompletableFuture() {
        return completableFuture;
    }

    public void setCompletableFuture(CompletableFuture<UserVo> completableFuture) {
        this.completableFuture = completableFuture;
    }

    @Override
    public String toString() {
        return "QueryUserDto{" +
                "userId='" + userId + '\'' +
                '}';
    }
}
