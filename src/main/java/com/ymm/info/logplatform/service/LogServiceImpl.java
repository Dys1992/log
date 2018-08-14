package com.ymm.info.logplatform.service;

import com.ymm.info.logplatform.entity.LogEntity;
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
    public int insert(LogEntity logEntity) {
        mongoTemplate.insert(logEntity);
        return 1;
    }

    @Override
    public List<LogEntity> findAll() {
        return mongoTemplate.findAll(LogEntity.class);
    }

    @Override
    public List<LogEntity> findLog(String deviceId, String channel, long beginTime, long endTime) {

        Query query = new Query(Criteria.where("deviceId").is(deviceId).and("channel").is(channel).and("timeStamp").gte(beginTime).lte(endTime));
        return mongoTemplate.find(query,LogEntity.class);
    }



}
