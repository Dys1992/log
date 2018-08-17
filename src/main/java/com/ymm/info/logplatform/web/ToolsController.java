package com.ymm.info.logplatform.web;

import com.ymm.info.logplatform.enums.ResponseEnum;
import com.ymm.info.logplatform.model.DateConvertTimeStampVO;
import com.ymm.info.logplatform.model.ResponseVO;
import com.ymm.info.logplatform.model.TimeStampVO;
import com.ymm.info.logplatform.utils.DateUtil;
import com.ymm.info.logplatform.utils.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;

/**
 * @author fanyu9488
 * @version Id: ToolsController, v 0.1 2018/8/17 11:27 fanyu9488 Exp $
 */

@RestController
@RequestMapping(value = "/tools")
public class ToolsController {

    @RequestMapping(value = "/nowTimeStamp/{mode}")
    public ResponseVO getNowTimeStamp(@PathVariable("mode") int mode){
        if (mode==1){
            return ResponseUtil.success(String.valueOf(System.currentTimeMillis()));
        }
        else if(mode==2){
            return ResponseUtil.success(String.valueOf(System.currentTimeMillis() / 1000));

        }
        return ResponseUtil.fail(ResponseEnum.DATA_ERROR.getCode(),
                ResponseEnum.DATA_ERROR.getMsg(),null);
    }

    @RequestMapping(value = "/timeStamp",method = RequestMethod.POST)
    public ResponseVO getDateByTimeStamp(@RequestBody TimeStampVO timeStampVO){
        long time = timeStampVO.getTimeStamp();
        String parrent = timeStampVO.getParrent();
        if(String.valueOf(time).length()==13){
            return ResponseUtil.success(DateUtil.getDate(time,parrent));
        }
        else if (String.valueOf(time).length()==10){
            return ResponseUtil.success(DateUtil.getDate(time*1000L,parrent));
        }

        return ResponseUtil.fail(ResponseEnum.DATA_ERROR.getCode(),
                ResponseEnum.DATA_ERROR.getMsg(),null);
    }


    @RequestMapping(value = "/date",method = RequestMethod.POST)
    public ResponseVO getTimeStampByDate(@RequestBody DateConvertTimeStampVO dateConvertTimeStampVO) throws ParseException {
        String date = dateConvertTimeStampVO.getDate();
        DateFormat dateFormat = DateUtil.getNewDateFormat("yyyy:MM:dd HH:mm:ss");
        int mode = dateConvertTimeStampVO.getMode();
        if(mode == 1){
            return ResponseUtil.success(String.valueOf(dateFormat.parse(date).getTime() / 1000));
        }
        else if(mode == 2){
            return ResponseUtil.success(String.valueOf(dateFormat.parse(date).getTime()));
        }
        return ResponseUtil.fail(ResponseEnum.DATA_ERROR.getCode(),
                ResponseEnum.DATA_ERROR.getMsg(),null);

    }

}
