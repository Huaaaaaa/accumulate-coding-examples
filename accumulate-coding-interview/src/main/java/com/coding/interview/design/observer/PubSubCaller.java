package com.coding.interview.design.observer;

/**
 * @Author: Bug改了我
 * @CreateTime: 2021/12/15 4:09 下午
 * @Description:
 */
public class PubSubCaller {

    private static int test = 10;

    public static void main(String[] args) {
        SubscriberUser zhangsan = new SubscriberUserZhang("zhangsan");
        SubscriberUser lisi = new SubscriberUserZhang("lisi");
        Publisher publisher = new PublisherJava();
        publisher.addSubscriber(zhangsan);
        publisher.addSubscriber(lisi);
        publisher.publishArticle();
        test = test + 5;
        System.out.println(test);
    }
}
