package com.ymm.info.logplatform.service.impl;


import com.ymm.info.logplatform.model.LogVO;
import com.ymm.info.logplatform.model.QueryFormVO;
import com.ymm.info.logplatform.service.LogService;
import com.ymm.info.logplatform.utils.DateUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;

/**
 * @author fanyu9488
 * @version Id: LogServiceImpl, v 0.1 2018/8/10 16:13 fanyu9488 Exp $
 */
@Repository("logDao")
public class LogServiceImpl implements LogService {
    private static final Logger log = Logger.getLogger(LogServiceImpl.class);

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public void insert(LogVO logVO) {
        mongoTemplate.insert(logVO);
    }

    @Override
    public List<LogVO> list(QueryFormVO queryFormVO) {
        String startTime = String.valueOf(Objects.requireNonNull(DateUtil.parseDateNewFormat(queryFormVO.getFromDate())).getTime());
        String endTime = String.valueOf(Objects.requireNonNull(DateUtil.parseDateNewFormat(queryFormVO.getToDate())).getTime());
        Query query = new Query(Criteria.where("timeStamp").gte(startTime).lte(endTime).and("channel").is(queryFormVO.getChannel()).and("deviceId").is(queryFormVO.getDeviceId()));
        return mongoTemplate.find(query, LogVO.class);
    }
}
