package com.ymm.info.logplatform.web.form;

import java.io.Serializable;

/**
 * The type Result msg.
 *
 * @author wuyayuan
 * @version Id : ResultMsg, v 0.1 2018/8/14 11:37 wuyayuan Exp $
 */
public class ResultMsg implements Serializable {

    private static final long serialVersionUID = -7379303002074816313L;
    /**
     * The Result.
     */
    private boolean           result           = true;

    /**
     * The Message.
     */
    private String            message;

    /**
     * The error code.
     */
    private String            errorCode;

    /**
     * data
     */
    private Object            obj;

    /**
     * Instantiates a new Result msg.
     */
    public ResultMsg() {
    }

    /**
     * Instantiates a new Result msg.
     *
     * @param result  the result
     * @param message the message
     * @param obj     the obj
     */
    public ResultMsg(boolean result, String message, Object obj) {
        this.result = result;
        this.message = message;
        this.obj = obj;
    }

    /**
     * Success result msg.
     *
     * @return the result msg
     */
    public static ResultMsg success() {
        return new ResultMsg(true, "sucess", null);
    }

    /**
     * Instantiates a new Result msg.
     *
     * @param result  the result
     * @param message the message
     */
    public ResultMsg(boolean result, String message) {
        this(result, message, null);
    }

    /**
     * Is result boolean.
     *
     * @return the boolean
     */
    public boolean isResult() {
        return result;
    }

    /**
     * Sets result.
     *
     * @param result the result
     */
    public void setResult(boolean result) {
        this.result = result;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets error code.
     *
     * @return the error code
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Sets error code.
     *
     * @param errorCode the error code
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * Gets obj.
     *
     * @return the obj
     */
    public Object getObj() {
        return obj;
    }

    /**
     * Sets obj.
     *
     * @param obj the obj
     */
    public void setObj(Object obj) {
        this.obj = obj;
    }
}
