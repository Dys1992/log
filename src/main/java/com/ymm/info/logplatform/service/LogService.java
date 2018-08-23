package com.ymm.info.logplatform.service;



import com.ymm.info.logplatform.model.LogVO;
import com.ymm.info.logplatform.model.PageVO;
import com.ymm.info.logplatform.model.QueryFormVO;

import java.text.ParseException;
import java.util.List;

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
    PageVO<LogVO> list(QueryFormVO queryFormVO) throws ParseException;

    List<LogVO> all();
}
