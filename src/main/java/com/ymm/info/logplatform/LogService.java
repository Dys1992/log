package com.ymm.info.logplatform;

import com.mongodb.client.result.DeleteResult;
import com.ymm.info.logplatform.entity.LogEntity;

import java.util.List;

/**
 * @author fanyu9488
 * @version Id: LogService, v 0.1 2018/8/10 17:23 fanyu9488 Exp $
 */
public interface LogService {
    int insert(LogEntity logEntity);
    List<LogEntity> findAll();
    List<LogEntity> findLog(String deviceId, String channel, long beginTime, long endTime);
}
