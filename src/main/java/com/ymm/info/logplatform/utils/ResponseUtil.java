package com.ymm.info.logplatform.utils;


import com.ymm.info.logplatform.entity.ResponseEntity;
import com.ymm.info.logplatform.enums.ResponseEnum;

/**
 * @author fanyu9488
 * @version Id: ResponseUtil, v 0.1 2018/8/9 16:59 fanyu9488 Exp $
 */
public class ResponseUtil {

    public static ResponseEntity success(Object obj){
        ResponseEntity responseEntity = new ResponseEntity();
         responseEntity.setCode(ResponseEnum.SUCCESS.getCode());
         responseEntity.setMsg(ResponseEnum.SUCCESS.getMsg());
         responseEntity.setResult(obj);
         return responseEntity;
    }

    public static ResponseEntity fail(int code , String msg , Object obj){
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setCode(code);
        responseEntity.setMsg(msg);
        responseEntity.setResult(obj);
        return responseEntity;
    }
}
