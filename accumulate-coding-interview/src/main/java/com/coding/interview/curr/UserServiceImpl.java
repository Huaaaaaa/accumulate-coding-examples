package com.coding.interview.curr;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2021/12/31 12:08 下午
 * @description:
 */
@Slf4j
public class UserServiceImpl implements UserService {


    @Override
    public UserVo getUser(String userId) {
        return new UserVo(userId, "userName-" + userId);
    }

    @Override
    public List<UserVo> getUserBatch(List<String> userIds) {
        int size = userIds.size();
        return IntStream.range(0, size).mapToObj(userIds::get).map(userId -> new UserVo(userId, "userName-" + userId)).collect(Collectors.toCollection(() -> new ArrayList<>(size)));
    }
}
