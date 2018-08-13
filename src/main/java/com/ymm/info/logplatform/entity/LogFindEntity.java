package com.ymm.info.logplatform.entity;

/**
 * @author fanyu9488
 * @version Id: LogFindEntity, v 0.1 2018/8/13 10:18 fanyu9488 Exp $
 */
public class LogFindEntity {

    //用户id
    private String deviceId;

    //客户端
    private String channel;

    //日期
    private long beginTime;

    //日期
    private long endTime;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(long beginTime) {
        this.beginTime = beginTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
}
