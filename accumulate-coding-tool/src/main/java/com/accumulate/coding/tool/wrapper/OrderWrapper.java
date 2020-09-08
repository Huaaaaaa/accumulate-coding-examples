package com.accumulate.coding.tool.wrapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * @ClassName OrderWrapper
 * @Description TODO
 * @Date 2020/8/30  17:53
 */
public class OrderWrapper {


    /**
     * get condition with orderNumber
     *
     * @param orderNumber
     * @return
     */
    public static Wrapper getOrderNumberWrapper(String orderNumber) {
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_number", orderNumber);
        return queryWrapper;
    }

    /**
     * get condition with userName
     *
     * @param userName
     * @return
     */
    public static Wrapper getUserNameWrapper(String userName) {
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userName);
        return queryWrapper;
    }

}
