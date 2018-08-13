package com.ymm.info.logplatform.entity;

/**
 * @author fanyu9488
 * @version Id: LogEntity, v 0.1 2018/8/9 16:53 fanyu9488 Exp $
 */
public class LogEntity {

    //用户id
    private String deviceId;

    //客户端
    private String channel;

    //日期
    private long timeStamp;

    //log
    private Object logInfo;

    public String  getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String  deviceId) {
        this.deviceId = deviceId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Object getLogInfo() {
        return logInfo;
    }

    public void setLogInfo(Object logInfo) {
        this.logInfo = logInfo;
    }
}
