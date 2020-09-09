package com.accumulate.coding.tool.dao;

import com.accumulate.coding.tool.enums.ProductTypeEnum;
import com.accumulate.coding.tool.enums.TimeUnitEnum;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

/**
 * @ClassName OrderItem
 * @Description 订单详情
 * @Date 2020/8/18  11:37
 */
@Entity
@TableName(value = "t_account_idp_principal", autoResultMap = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails implements Serializable {

    private static final long serialVersionUID = -1362984189247003747L;

    @Column(name = "order_number")
    private String orderNumber;


    @Column(name = "order_number")
    @Enumerated(EnumType.ORDINAL)
    private ProductTypeEnum productType;

    @Column(name = "product_info")
    @TableField(typeHandler = JacksonTypeHandler.class)
    private String productInfo;


    @Column(name = "time_unit")
    @Enumerated(EnumType.ORDINAL)
    private TimeUnitEnum timeUnit;

    @Column(name = "time_span")
    private Integer timeSpan;

    @Column(name = "pay_time")
    private long payTime;

}
