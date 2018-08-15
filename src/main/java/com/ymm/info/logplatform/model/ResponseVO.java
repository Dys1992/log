package com.ymm.info.logplatform.model;

/**
 * @author fanyu9488
 * @version Id: ResponseVO, v 0.1 2018/8/9 16:58 fanyu9488 Exp $
 */
public class ResponseVO<T> {

    private int code;
    private String msg;
    private T result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
