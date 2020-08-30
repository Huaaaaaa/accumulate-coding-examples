package com.accumulate.coding.tool.dao;

import com.accumulate.coding.tool.enums.OrderStatusEnum;
import com.accumulate.coding.tool.enums.OrderTypeEnum;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @ClassName Order
 * @Description 订单表
 * @Date 2020/8/18  11:37
 */
@Entity
@Table(name = "order")
@Data
public class Order {

    @Id
    @Column(name = "id")
    private Long id;


    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "type")
    @Enumerated(EnumType.ORDINAL)
    private OrderTypeEnum orderType;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "update_time")
    private Timestamp updateTime;

    @Column(name = "order_status")
    @Enumerated(EnumType.ORDINAL)
    private OrderStatusEnum orderStatus;
}
