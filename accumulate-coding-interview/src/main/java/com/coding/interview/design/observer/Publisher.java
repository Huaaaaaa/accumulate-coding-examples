package com.coding.interview.design.observer;

/**
 * @Author: Bug改了我
 * @CreateTime: 2021/12/15 4:04 下午
 * @Description: 发布者接口
 */
public interface Publisher {

    /**
     * 添加订阅者
     *
     * @param subscriberUser
     */
    void addSubscriber(SubscriberUser subscriberUser);

    /**
     * 删除订阅者
     *
     * @param subscriberUser
     */
    void deleteSubscriber(SubscriberUser subscriberUser);

    /**
     * 发布文章
     */
    void publishArticle();

}
