package com.accumulate.coding.tool.dao;

import com.accumulate.coding.tool.enums.OrderStatusEnum;
import com.accumulate.coding.tool.enums.OrderTypeEnum;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName Order
 * @Description 订单表
 * @Date 2020/8/18  11:37
 */
@Builder
@TableName(value = "order", autoResultMap = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {

    private static final long serialVersionUID = 3593025191137705201L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "order_type")
    @Enumerated(EnumType.ORDINAL)
    private OrderTypeEnum orderType;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "create_time")
    private Long createTime;

    @Column(name = "update_time")
    private Long updateTime;

    @Column(name = "order_status")
    @Enumerated(EnumType.ORDINAL)
    private OrderStatusEnum orderStatus;
}
