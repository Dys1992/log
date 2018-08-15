package com.ymm.info.logplatform.biz.mapper;

import com.ymm.info.logplatform.biz.mapper.converter.FullDateConverter;
import com.ymm.info.logplatform.biz.model.LogVO;
import com.ymm.info.logplatform.entity.LogEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * @author wuyayuan
 * @version Id: LogMapper, v 0.1 2018/8/14 14:55 wuyayuan Exp $
 */
@Mapper(componentModel = "spring", uses = { FullDateConverter.class }, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
@Component(value = "logMapper")
public interface LogMapper {

    LogEntity vo2entity(LogVO logVO);

    LogVO entity2vo(LogEntity logEntity);

    List<LogVO> entities2vos(Collection<LogEntity> entities);
}
