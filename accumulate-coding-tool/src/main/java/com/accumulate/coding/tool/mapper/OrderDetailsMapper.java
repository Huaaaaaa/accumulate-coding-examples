package com.accumulate.coding.tool.mapper;

import com.accumulate.coding.tool.dao.OrderDetails;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @ClassName OrderDetails
 * @Description
 * @Date 2020/8/30  17:35
 */
@Repository
@Mapper
public interface OrderDetailsMapper extends BaseMapper<OrderDetails> {
}
