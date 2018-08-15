package com.ymm.info.logplatform.web;

import com.ymm.info.logplatform.biz.model.LogVO;
import com.ymm.info.logplatform.biz.model.QueryFormVO;
import com.ymm.info.logplatform.biz.service.LogService;
import com.ymm.info.logplatform.web.form.ResultMsg;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wuyayuan
 * @version Id: LogMngController, v 0.1 2018/8/14 11:35 wuyayuan Exp $
 */
@RestController
@RequestMapping("/log")
public class LogMngController extends BaseController {

    @Resource
    private LogService logService;

    @RequestMapping("/save")
    public ResultMsg submitLog(@RequestBody LogVO logVO) {
        if (logVO == null) {
            // 请求参数为空
            return new ResultMsg(Boolean.FALSE, EMPTY_OBJECT);
        }
        logService.insert(logVO);
        return new ResultMsg(Boolean.TRUE, ADD_SUCCESS);
    }

    @RequestMapping("/list")
    public ResultMsg query(@RequestBody QueryFormVO queryFormVO) {
        return new ResultMsg(Boolean.TRUE,SUCCESS,logService.list(queryFormVO));
    }
}
