package com.design.api;

import java.io.UnsupportedEncodingException;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/13
 * Todo:
 * Time 11:43
 */
public interface IBaiDuApi {

  String translate(String from,String to,String srcMsg) throws UnsupportedEncodingException;
}
