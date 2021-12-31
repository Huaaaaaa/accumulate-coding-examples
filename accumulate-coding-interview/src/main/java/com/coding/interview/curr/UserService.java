package com.coding.interview.curr;

import com.coding.interview.business.User;

import java.util.List;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2021/12/31 12:05 下午
 * @description:
 */
public interface UserService {

    UserVo getUser(String userId);


    List<UserVo> getUserBatch(List<String> userIds);
}
