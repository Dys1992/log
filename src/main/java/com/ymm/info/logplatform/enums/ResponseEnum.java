package com.ymm.info.logplatform.enums;

/**
 * @author fanyu9488
 * @version Id: ResponseEnum, v 0.1 2018/8/9 16:58 fanyu9488 Exp $
 */
public enum ResponseEnum {
    SUCCESS(0,"success"),
    DATA_ERROR(-1001,"请求参数错误"),
    SQL_ERROR(-1002,"入库失败"),
    ;

    private Integer code;
    private String msg;

    private ResponseEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode(){
        return  code;
    }

    public String getMsg(){
        return msg;
    }
}
