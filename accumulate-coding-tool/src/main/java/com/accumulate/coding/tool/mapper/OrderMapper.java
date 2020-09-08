package com.accumulate.coding.tool.mapper;

import com.accumulate.coding.tool.dao.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @ClassName OrderMapper
 * @Description
 * @Date 2020/8/30  17:33
 */
@Repository
@Mapper
public interface OrderMapper extends BaseMapper<Order> {


}
