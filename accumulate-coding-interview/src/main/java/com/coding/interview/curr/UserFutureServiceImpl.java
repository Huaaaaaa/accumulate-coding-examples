package com.coding.interview.curr;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2021/12/31 12:25 下午
 * @description:
 */
@Slf4j
public class UserFutureServiceImpl {

    private UserService userService = new UserServiceImpl();

    //任务队列
    private LinkedBlockingQueue<QueryUserDto> taskQueue = new LinkedBlockingQueue<QueryUserDto>();

    {
        //创建延时线程池
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        //每隔5秒执行一次批量查询接口
        executorService.scheduleAtFixedRate(new ConsumerTask(), 5, 2, TimeUnit.SECONDS);
    }

    /**
     * 将请求封装成QueryUserDto放入任务队列中
     *
     * @param userId
     * @return
     */
    public UserVo getUserBatchWithFuture(String userId) {
        QueryUserDto queryUserDto = new QueryUserDto(userId);
        CompletableFuture<UserVo> completableFuture = new CompletableFuture<>();
        queryUserDto.setCompletableFuture(completableFuture);
        taskQueue.add(queryUserDto);
        UserVo userVo = null;
        try {
            //此处会阻塞，直到complete方法被调用
            userVo = completableFuture.get();
            //log.info("getUserBatchWithFuture userVo={}", userVo.toString());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return userVo;
    }


    /**
     * 从队列获取任务批量执行
     */
    private class ConsumerTask implements Runnable {


        @Override
        public void run() {
            List<QueryUserDto> taskList = new ArrayList<>();
            List<String> userIdList = new ArrayList<>();
            int size = taskQueue.size();
            /*
             * 从队列中获取请求
             */
            if (size > 0) {
                System.out.println("------任务开始执行------");
                for (int i = 0; i < size; i++) {
                    QueryUserDto queryUserDto = taskQueue.poll();
                    if (null != queryUserDto) {
                        taskList.add(queryUserDto);
                        userIdList.add(queryUserDto.getUserId());
                    }
                }
                List<UserVo> userVos = userService.getUserBatch(userIdList);
                Map<String, UserVo> userVoMap = userVos.stream().collect(Collectors.toMap(UserVo::getUserId, vo -> vo, (a, b) -> b));
                for (QueryUserDto qud : taskList) {
                    qud.getCompletableFuture().complete(userVoMap.get(qud.getUserId()));
                }
                System.out.println("------任务执行结束------");
            }
        }
    }
}
