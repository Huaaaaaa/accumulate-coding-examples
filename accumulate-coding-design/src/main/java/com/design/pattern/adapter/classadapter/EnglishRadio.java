package com.design.pattern.adapter.classadapter;

import org.springframework.util.StringUtils;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/13
 * Todo: 定义一个英语电台，收听中国记者的发言
 * Time 10:13
 */
public class EnglishRadio {

    public void broadCast(IReporter iReporter) {
        String message = iReporter.translate();
        if (!StringUtils.isEmpty(message)) {
            System.out.println("Chinese reporter say:" + message);
        } else {
            System.out.println("Nothing");
        }

    }
}
