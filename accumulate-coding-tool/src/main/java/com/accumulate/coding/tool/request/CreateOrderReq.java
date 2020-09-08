package com.accumulate.coding.tool.request;

import com.accumulate.coding.tool.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName CreateOrderReq
 * @Description TODO
 * @Date 2020/8/30  22:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderReq implements Serializable {


    private static final long serialVersionUID = 8570717791232072054L;

    private OrderEntity orderEntity;


}
