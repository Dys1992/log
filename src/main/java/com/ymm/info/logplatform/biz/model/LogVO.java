package com.ymm.info.logplatform.biz.model;

import java.io.Serializable;

/**
 * The type Log vo.
 *
 * @author wuyayuan
 * @version Id : LogVO, v 0.1 2018/8/14 13:57 wuyayuan Exp $
 */
public class LogVO implements Serializable {

    private static final long serialVersionUID = 3080712323510402883L;

    /** 设备号 */
    private String            deviceId;

    /** 渠道 */
    private String            channel;

    /** 日期 */
    private String            timeStamp;

    /** 日志信息 */
    private Object            logInfo;

    /**
     * Gets device id.
     *
     * @return the device id
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * Sets device id.
     *
     * @param deviceId the device id
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * Gets channel.
     *
     * @return the channel
     */
    public String getChannel() {
        return channel;
    }

    /**
     * Sets channel.
     *
     * @param channel the channel
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * Gets time stamp.
     *
     * @return the time stamp
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * Sets time stamp.
     *
     * @param timeStamp the time stamp
     */
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * Gets log info.
     *
     * @return the log info
     */
    public Object getLogInfo() {
        return logInfo;
    }

    /**
     * Sets log info.
     *
     * @param logInfo the log info
     */
    public void setLogInfo(Object logInfo) {
        this.logInfo = logInfo;
    }

    @Override
    public String toString() {
        return "LogVO{" + "deviceId='" + deviceId + '\'' + ", channel='" + channel + '\'' + ", timeStamp='" + timeStamp + '\'' + ", logInfo=" + logInfo + '}';
    }
}
