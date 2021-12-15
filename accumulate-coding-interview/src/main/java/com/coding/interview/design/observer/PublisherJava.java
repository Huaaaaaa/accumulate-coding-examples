package com.coding.interview.design.observer;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Bug改了我
 * @CreateTime: 2021/12/15 4:07 下午
 * @Description:
 */
public class PublisherJava implements Publisher {

    private List<SubscriberUser> subscriberUserList;

    @Override
    public void addSubscriber(SubscriberUser subscriberUser) {
        if (CollectionUtils.isEmpty(subscriberUserList)) {
            subscriberUserList = new ArrayList<>();
        }
        subscriberUserList.add(subscriberUser);
    }

    @Override
    public void deleteSubscriber(SubscriberUser subscriberUser) {
        if (null != subscriberUserList && subscriberUserList.contains(subscriberUser)) {
            subscriberUserList.remove(subscriberUser);
        }
    }

    @Override
    public void publishArticle() {
        for (SubscriberUser user : subscriberUserList) {
            user.read();
        }
    }
}
