package com.ymm.info.logplatform.model;

import java.io.Serializable;

/**
 * The type Log vo.
 *
 * @author wuyayuan
 * @version Id : LogVO, v 0.1 2018/8/14 13:57 wuyayuan Exp $
 */
public class QueryFormVO implements Serializable {

    private static final long serialVersionUID = 3080712323510402883L;

    /** 设备号 */
    private String            deviceId;

    /** 渠道 */
    private String            channel;

    /** 开始日期 */
    private String            fromDate;

    /** 结束日期 */
    private String            toDate;

    private int               page;

    private int               size;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

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
     * Gets from date.
     *
     * @return the from date
     */
    public String getFromDate() {
        return fromDate;
    }

    /**
     * Sets from date.
     *
     * @param fromDate the from date
     */
    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    /**
     * Gets to date.
     *
     * @return the to date
     */
    public String getToDate() {
        return toDate;
    }

    /**
     * Sets to date.
     *
     * @param toDate the to date
     */
    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    @Override
    public String toString() {
        return "QueryFormVO{" + "deviceId='" + deviceId + '\'' + ", channel='" + channel + '\'' + ", fromDate='" + fromDate + '\'' + ", toDate='" + toDate + '\'' + '}';
    }
}
