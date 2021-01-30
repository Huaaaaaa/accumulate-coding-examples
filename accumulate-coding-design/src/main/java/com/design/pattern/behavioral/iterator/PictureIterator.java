package com.design.pattern.behavioral.iterator;

import java.io.PipedInputStream;
import java.util.List;

/**
 * Author: huayingcao2
 * DateTime: 2021/1/30  21:13
 * Description:
 */
public class PictureIterator implements CustomIterator {

    private List<Picture> pictures;

    private int index;

    public PictureIterator(List<Picture> pictures) {
        this.pictures = pictures;
    }

    /**
     * 是否存在下一个
     *
     * @return
     */
    @Override
    public boolean hasNext() {
        return index < pictures.size() - 1;
    }

    /**
     * 获取第一个
     *
     * @return
     */
    @Override
    public Picture first() {
        index = 0;
        return pictures.get(index);
    }

    /**
     * 获取最后一个
     *
     * @return
     */
    @Override
    public Picture last() {
        index = pictures.size() - 1;
        return pictures.get(index);
    }

    /**
     * 获取下一个
     *
     * @return
     */
    @Override
    public Picture next() {
        if (hasNext()) {
           return pictures.get(++index);
        }
        return null;
    }

    /**
     * 获取前一个
     *
     * @return
     */
    @Override
    public Picture previous() {
        if (index > 0) {
            return pictures.get(--index);
        }
        return null;
    }
}
