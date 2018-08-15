package com.ymm.info.logplatform.utils;


import com.ymm.info.logplatform.model.ResponseVO;
import com.ymm.info.logplatform.enums.ResponseEnum;

/**
 * @author fanyu9488
 * @version Id: ResponseUtil, v 0.1 2018/8/9 16:59 fanyu9488 Exp $
 */
public class ResponseUtil {

    public static ResponseVO success(Object obj){
        ResponseVO responseVO = new ResponseVO();
         responseVO.setCode(ResponseEnum.SUCCESS.getCode());
         responseVO.setMsg(ResponseEnum.SUCCESS.getMsg());
         responseVO.setResult(obj);
         return responseVO;
    }

    public static ResponseVO fail(int code , String msg , Object obj){
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(code);
        responseVO.setMsg(msg);
        responseVO.setResult(obj);
        return responseVO;
    }
}
