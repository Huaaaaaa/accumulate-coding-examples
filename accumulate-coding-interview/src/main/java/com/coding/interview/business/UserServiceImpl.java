package com.coding.interview.business;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author: huayingcao
 * @createTime: 2021/12/12 8:28 下午
 * @description:
 */
public class UserServiceImpl implements UserService {

    private ConcurrentHashMap<Long, User> userMap1 = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Long, User> userMap2 = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Long, User> userMap3 = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Long, User> userMap4 = new ConcurrentHashMap<>();
    private AtomicLong counter = new AtomicLong(0);
    private final int tableSize = 4;
    private ConcurrentHashMap<Long, User>[] tables = new ConcurrentHashMap[]{userMap1, userMap2, userMap3, userMap4};

    @Override
    public Boolean register(User user) {
        Long userId = counter.incrementAndGet();
        Boolean res = false;
        int i = userId.hashCode();
        int index = i % tableSize;
        System.out.println(index);
        ConcurrentHashMap table = tables[index];
        User exist = (User) table.get(userId);
        if (exist == null) {
            table.put(userId, user);
            res = true;
        }
        return res;
    }


    private static int userNum = 0;

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                User user = new User();
                user.setUserName("userName-" + (userNum++));
                user.setNickName("nickName-" + (userNum++));
                Boolean register = userService.register(user);
                System.out.println(Thread.currentThread() + "注册" + (register ? "成功" : "失败"));
            }).start();
        }
    }
}
