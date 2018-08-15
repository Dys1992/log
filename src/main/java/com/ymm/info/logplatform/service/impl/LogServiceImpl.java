package com.ymm.info.logplatform.service.impl;


import com.ymm.info.logplatform.model.LogVO;
import com.ymm.info.logplatform.model.QueryFormVO;
import com.ymm.info.logplatform.service.LogService;
import com.ymm.info.logplatform.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author fanyu9488
 * @version Id: LogServiceImpl, v 0.1 2018/8/10 16:13 fanyu9488 Exp $
 */
@Repository("logDao")
public class LogServiceImpl implements LogService {


    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public void insert(LogVO logVO) {
        mongoTemplate.insert(logVO);
    }

    @Override
    public List<LogVO> list(QueryFormVO queryFormVO) {
        String startTime = String.valueOf(DateUtil.parseDateNewFormat(queryFormVO.getFromDate()).getTime());
        String endTime = String.valueOf(DateUtil.parseDateNewFormat(queryFormVO.getToDate()).getTime());
        Query query = new Query(Criteria.where("timeStamp").gte(startTime).and("channel").is(queryFormVO.getChannel()).and("deviceId").is(queryFormVO.getDeviceId()));
        List<LogVO> list = mongoTemplate.find(query, LogVO.class);
        return list;
    }
}
