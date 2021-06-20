package com.design.pattern.structrual.adapter.classadapter;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/13
 * Todo: 定义一个记者适配器类（翻译器），用来将中文翻译成英文
 * Time 10:09
 */
@Slf4j
public class ReporterAdapter extends ChineseReporter implements IReporter {

    /*@Resource
    private IBaiDuApi iBaiDuApi;*/

    @Override
    public String translate() {
        /*String src = say();
        String des = "";
        try {
            des = iBaiDuApi.translate(src, "zh", "en");
        } catch (UnsupportedEncodingException e) {
            log.error("ReporterAdapter translate error={}", e);
        }*/
        return "";
    }
}
