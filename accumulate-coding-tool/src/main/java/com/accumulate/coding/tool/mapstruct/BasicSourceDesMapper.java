package com.accumulate.coding.tool.mapstruct;

import org.mapstruct.Mapper;

/**
 * @ClassName BasicSourceDesMapper
 * @Description 使用Mapper注解后才会自动生成接口实现类
 * @Author huayingcao2
 * @Date 2020/8/17  16:46
 */
@Mapper(componentModel = "spring")
public interface BasicSourceDesMapper {

    /**
     * Source to destination
     *
     * @param basicSourceVo
     * @return
     */
    BasicDesVo basicSourceToDes(BasicSourceVo basicSourceVo);


    /**
     * Destination to source
     *
     * @param basicDesVo
     * @return
     */
    BasicSourceVo basicDesToSource(BasicDesVo basicDesVo);
}
