package com.ymm.info.logplatform.web;

import com.ymm.info.logplatform.model.LogVO;
import com.ymm.info.logplatform.model.QueryFormVO;
import com.ymm.info.logplatform.model.ResponseVO;
import com.ymm.info.logplatform.service.LogService;
import com.ymm.info.logplatform.enums.ResponseEnum;
import com.ymm.info.logplatform.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author fanyu9488
 * @version Id: LogController, v 0.1 2018/8/9 19:33 fanyu9488 Exp $
 */

@RestController
@RequestMapping("/ymm-info-log/")
public class LogController {
    @Autowired
    private LogService logService;

    @RequestMapping("/submitlog")
    public ResponseVO submitLog(@RequestBody LogVO logVO){
        if (logVO == null) {
            // 请求参数为空
            return ResponseUtil.fail(ResponseEnum.DATA_ERROR.getCode(),ResponseEnum.DATA_ERROR.getMsg(),null);
        }
        logService.insert(logVO);
        return ResponseUtil.success(1);
    }



    @RequestMapping("/loglist")
    public ResponseVO findLog(@RequestBody QueryFormVO queryFormVO){
        return ResponseUtil.success(logService.list(queryFormVO));
    }


}
