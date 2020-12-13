package com.accumulate.coding.middle.api;

import lombok.Data;

import java.io.Serializable;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/13
 * Todo:
 * Time 11:46
 */
@Data
public class BaiDuTranslateResult implements Serializable {


    private static final long serialVersionUID = 911358996765919146L;

    private String from;

    private String to;

    private TranslateResult[] trans_result;

    private Integer error_code;
}
