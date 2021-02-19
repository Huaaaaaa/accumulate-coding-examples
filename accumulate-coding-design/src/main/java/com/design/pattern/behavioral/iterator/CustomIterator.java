package com.design.pattern.behavioral.iterator;

import sun.java2d.pipe.PixelToParallelogramConverter;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/1/30  21:10
 * Description: 自定义一个迭代器，提供获取第一个、最后一个、上一个、下一个、判断是否存在下一个功能
 */
public interface CustomIterator {

    boolean hasNext();

    Picture first();

    Picture last();

    Picture next();

    Picture previous();
}
