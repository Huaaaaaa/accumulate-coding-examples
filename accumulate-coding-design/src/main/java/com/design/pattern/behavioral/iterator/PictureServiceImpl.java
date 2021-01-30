package com.design.pattern.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: huayingcao2
 * DateTime: 2021/1/30  21:27
 * Description:
 */
public class PictureServiceImpl implements PictureService {

    private List<Picture> pictures = new ArrayList<>();

    /**
     * 添加照片
     *
     * @param picture
     * @return
     */
    @Override
    public boolean add(Picture picture) {
        if (picture != null) {
            return pictures.add(picture);
        }
        return false;
    }

    /**
     * 删除照片
     *
     * @param picture
     * @return
     */
    @Override
    public boolean remove(Picture picture) {
        if (pictures.contains(picture)) {
            return pictures.remove(picture);
        }
        return false;
    }


    /**
     * 获取照片迭代器
     *
     * @return
     */
    @Override
    public PictureIterator getPictureIterator() {
        return new PictureIterator(pictures);
    }
}
