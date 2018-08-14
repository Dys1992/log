package com.ymm.info.logplatform.controller;

import com.ymm.info.logplatform.service.LogService;
import com.ymm.info.logplatform.entity.LogEntity;
import com.ymm.info.logplatform.entity.LogFindEntity;
import com.ymm.info.logplatform.entity.ResponseEntity;
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
    public ResponseEntity submitLog(@RequestBody LogEntity logEntity){
        String deviceId = logEntity.getDeviceId();
        String channel = logEntity.getChannel();
        if (deviceId.length()>2 && channel.length()>2){
            logService.insert(logEntity);
           return ResponseUtil.success(1);
        }
        return ResponseUtil.fail(ResponseEnum.DATA_ERROR.getCode(),
                ResponseEnum.DATA_ERROR.getMsg(), 0);
    }



    @RequestMapping("/loglist")
    public ResponseEntity findLog(@RequestBody LogFindEntity logFindEntity){
            String deviceId = logFindEntity.getDeviceId();
            String channel = logFindEntity.getChannel();
            long beginTime = logFindEntity.getBeginTime() ;
            long endTime = logFindEntity.getEndTime();
        return ResponseUtil.success(logService.findLog(deviceId,channel,beginTime,endTime));
    }


    @RequestMapping(value = "/findlog/all",method = RequestMethod.GET)
    public ResponseEntity findAll(){
        return ResponseUtil.success(logService.findAll());
    }



}
