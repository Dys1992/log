package com.ymm.info.logplatform.biz.service.impl;

import com.ymm.info.logplatform.biz.mapper.LogMapper;
import com.ymm.info.logplatform.biz.model.LogVO;
import com.ymm.info.logplatform.biz.model.QueryFormVO;
import com.ymm.info.logplatform.biz.service.LogService;
import com.ymm.info.logplatform.commom.util.DateUtil;
import com.ymm.info.logplatform.entity.LogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fanyu9488
 * @version Id: LogServiceImpl, v 0.1 2018/8/10 16:13 fanyu9488 Exp $
 */
@Service("logMngDao")
public class LogServiceImpl implements LogService {

    @Resource
    private MongoTemplate mongoTemplate;

    @Resource
    private LogMapper     logMapper;

    @Override
    public void insert(LogVO logVO) {
        mongoTemplate.insert(logMapper.vo2entity(logVO));
    }

    @Override
    public List<LogVO> list(QueryFormVO queryFormVO) {
        Long startTime = DateUtil.parseDateNewFormat(queryFormVO.getFromDate()).getTime();
        Long endTime = DateUtil.parseDateNewFormat(queryFormVO.getToDate()).getTime();
        Query query = new Query(Criteria.where("deviceId").is(queryFormVO.getDeviceId()).and("channel").is(queryFormVO.getChannel()).and("timeStamp").gte(startTime).lte(endTime));
        List<LogEntity> list = mongoTemplate.find(query, LogEntity.class);
        return logMapper.entities2vos(list);
    }

}
