package com.design.pattern.structrual.adapter.classadapter;

import com.design.api.BaiDuApiImpl;
import com.design.api.IBaiDuApi;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/13
 * Todo: 定义一个记者适配器类（翻译器），用来将中文翻译成英文
 * Time 10:09
 */
@Slf4j
public class ReporterAdapter extends ChineseReporter implements IReporter {

    @Override
    public String translate() {
        IBaiDuApi BaiDuApiImpl = new BaiDuApiImpl();
        String src = say();
        String des = "";
        try {
            des = BaiDuApiImpl.translate(src, "zh", "en");
        } catch (UnsupportedEncodingException e) {
            log.error("ReporterAdapter translate error={}", e);
        }
        return des;
    }
}
