package com.design.api;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/13
 * Todo:
 * Time 11:48
 */
@Data
public class TranslateResult implements Serializable {

    private static final long serialVersionUID = 1482982768239703234L;

    private String src;

    private String dst;
}
