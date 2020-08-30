package com.accumulate.coding.tool.dao;

import com.accumulate.coding.tool.enums.ProductTypeEnum;
import com.accumulate.coding.tool.enums.TimeUnitEnum;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @ClassName OrderItem
 * @Description 订单详情
 * @Date 2020/8/18  11:37
 */
@Entity
@Table(name = "order_item")
@Data
public class OrderItem {

    @Id
    private Long id;

    @Column(name = "order_number")
    private String orderNumber;


    @Column(name = "order_number")
    @Enumerated(EnumType.ORDINAL)
    private ProductTypeEnum productType;

    @Column(name = "product_detail")
    private String productDetail;


    @Column(name = "time_unit")
    @Enumerated(EnumType.ORDINAL)
    private TimeUnitEnum timeUnit;

    @Column(name = "time_span")
    private Integer timeSpan;

    @Column(name = "pay_time")
    private Timestamp payTime;

}
