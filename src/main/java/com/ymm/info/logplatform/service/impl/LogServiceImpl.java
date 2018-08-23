package com.ymm.info.logplatform.service.impl;


import com.ymm.info.logplatform.model.LogVO;
import com.ymm.info.logplatform.model.PageVO;
import com.ymm.info.logplatform.model.QueryFormVO;
import com.ymm.info.logplatform.service.LogService;
import com.ymm.info.logplatform.utils.DateUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.util.List;

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
    public PageVO<LogVO> list(QueryFormVO queryFormVO) throws ParseException {
        log.info(queryFormVO);
        log.info(queryFormVO.getFromDate()+"***"+queryFormVO.getToDate());


        String startTime = DateUtil.getTimeStamp(queryFormVO.getFromDate());
        String endTime = DateUtil.getTimeStamp(queryFormVO.getToDate());
        int page = queryFormVO.getPage();
        int size = queryFormVO.getSize();
        Query query = new Query();
        query.skip((page-1)*size);
        query.limit(size);
        query.addCriteria(Criteria.where("timeStamp").gte(startTime).lte(endTime).and("channel").is(queryFormVO.getChannel()).and("deviceId").is(queryFormVO.getDeviceId()));
        List<LogVO> list =  mongoTemplate.find(query, LogVO.class);
        long count = mongoTemplate.count(query, LogVO.class);
        PageVO<LogVO> page1 = new PageVO<>();
        page1.setRows(list);
        page1.setTotalCount(count);
        page1.setTotalPage(count%size==0?1:count/size+1);

        return page1;
    }

    @Override
    public List<LogVO> all() {
        return mongoTemplate.findAll(LogVO.class);
    }
}
