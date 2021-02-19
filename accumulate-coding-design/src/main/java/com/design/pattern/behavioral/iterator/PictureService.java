package com.design.pattern.behavioral.iterator;

import java.util.List;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/1/30  21:08
 * Description: 照片集，提供照片的添加、删除、遍历功能
 */
public interface PictureService {

     boolean add(Picture picture);

     boolean remove(Picture picture);

     PictureIterator getPictureIterator();



}
