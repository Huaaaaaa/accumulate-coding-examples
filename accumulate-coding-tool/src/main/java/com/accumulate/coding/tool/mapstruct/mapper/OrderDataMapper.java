package com.accumulate.coding.tool.mapstruct.mapper;

import com.accumulate.coding.tool.dao.Order;
import com.accumulate.coding.tool.dao.OrderDetails;
import com.accumulate.coding.tool.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @ClassName OrderDataMapper
 * @Description
 * @Author huayingcao2
 * @Date 2020/9/9  17:54
 */
@Mapper(componentModel = "spring")
public interface OrderDataMapper {

    OrderDataMapper INSTANCE = Mappers.getMapper(OrderDataMapper.class);


    /**
     * from OrderEntity to Order
     *
     * @param orderEntity
     * @return
     */
    @Mappings({
            @Mapping(target = "price", source = "orderEntity.orderPrice"),
            @Mapping(target = "orderType", expression = "java(com.accumulate.coding.tool.enums.OrderTypeEnum.getWithType(java.lang.Integer.parseInt(orderEntity.getOrderType())))")
    })
    Order entityToOrder(OrderEntity orderEntity);


    /**
     * from Order to OrderEntity
     *
     * @param order
     * @return
     */
    OrderEntity orderToEntity(Order order);


    /**
     * from OrderEntity to OrderDetails
     *
     * @param orderEntity
     * @return
     */
    @Mappings({
            @Mapping(target = "productType", expression = "java(com.accumulate.coding.tool.enums.ProductTypeEnum.getWithProductType(java.lang.Integer.parseInt(orderEntity.getProductType())))"),
    })
    OrderDetails entityToDetails(OrderEntity orderEntity);


    /**
     * from Order and OrderDetails to OrderEntity
     *
     * @param order
     * @param orderDetails
     * @return
     */
    @Mappings({
            @Mapping(target = "orderNumber", source = "order.orderNumber"),
            @Mapping(target = "orderType", source = "order.orderType"),
            @Mapping(target = "userName", source = "order.userName"),
            @Mapping(target = "orderPrice", source = "order.price"),
            @Mapping(target = "productType", source = "orderDetails.productType"),
            @Mapping(target = "productInfo", source = "orderDetails.productInfo"),
            @Mapping(target = "orderStatus", source = "order.orderStatus"),
            @Mapping(target = "timeUnit", source = "orderDetails.timeUnit"),
            @Mapping(target = "timeSpan", source = "orderDetails.timeSpan"),
            @Mapping(target = "createTime", source = "order.createTime"),
            @Mapping(target = "updateTime", source = "order.updateTime"),
            @Mapping(target = "payTime", source = "orderDetails.payTime"),
    })
    OrderEntity getEntity(Order order, OrderDetails orderDetails);
}
