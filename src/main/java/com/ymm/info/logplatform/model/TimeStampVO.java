package com.ymm.info.logplatform.model;

/**
 * @author fanyu9488
 * @version Id: TimeStampVO, v 0.1 2018/8/17 16:32 fanyu9488 Exp $
 */
public class TimeStampVO {
    private long timeStamp;
    private String parrent;

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getParrent() {
        return parrent;
    }

    public void setParrent(String parrent) {
        this.parrent = parrent;
    }

    @Override
    public String toString() {
        return "TimeStampVO{" + "timeStamp='" + timeStamp + '\'' + ", parrent='" + parrent + '}';
    }
}
