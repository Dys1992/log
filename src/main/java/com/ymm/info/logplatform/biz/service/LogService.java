package com.ymm.info.logplatform.biz.service;

import java.util.List;

import com.ymm.info.logplatform.biz.model.LogVO;
import com.ymm.info.logplatform.biz.model.QueryFormVO;
import com.ymm.info.logplatform.entity.LogEntity;

/**
 * @author fanyu9488
 * @version Id: LogService, v 0.1 2018/8/10 17:23 fanyu9488 Exp $
 */
public interface LogService {

    /**
     * 新增
     *
     * @param logVO
     * @return
     */
    void insert(LogVO logVO);

    /**
     * 按条件查询
     *
     * @param queryFormVO
     * @return
     */
    List<LogVO> list(QueryFormVO queryFormVO);
}
