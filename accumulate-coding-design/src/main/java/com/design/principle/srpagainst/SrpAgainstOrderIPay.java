package com.design.principle.srpagainst;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/5
 * Todo:
 * Time 23:47
 */
public class SrpAgainstOrderIPay implements SrpAgainstIPay {

    @Override
    public String pay(String payMethod) {
        return payMethod;
    }
}
