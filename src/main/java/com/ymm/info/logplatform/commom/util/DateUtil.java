package com.ymm.info.logplatform.commom.util;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期工具类
 *
 * @author wyy32641
 * @version Id: DateUtil, v 0.1 2018/8/14 14:17 wyy32641 Exp $
 */
public class DateUtil {

    /** seconds of day */
    public final static long    ONE_DAY_SECONDS      = 86400;

    /** millseconds of day */
    public final static long    ONE_DAY_MILL_SECONDS = 86400000;

    /** yyyyMMdd日期格式 */
    public final static String  shortFormat          = "yyyyMMdd";

    /** yyyyMMddHHmmss日期格式 */
    public final static String  longFormat           = "yyyyMMddHHmmss";

    /** yyyy-MM-dd日期格式 */
    public final static String  webFormat            = "yyyy-MM-dd";

    /** HHmmss日期格式 */
    public final static String  timeFormat           = "HHmmss";

    /** yyyy年MM月dd日 日期格式 */
    public final static String  chineseDtFormat      = "yyyy年MM月dd日";

    /** yyyy-MM-dd HH:mm:ss日期格式 */
    public final static String  newFormat            = "yyyy-MM-dd HH:mm:ss";

    /** yyyy-MM-dd HH:mm日期格式 */
    public final static String  noSecondFormat       = "yyyy-MM-dd HH:mm";

    /**
     * 私有构造函数
     */
    private DateUtil() {
    }

    /**
     * @param pattern
     * @return
     */
    public static DateFormat getNewDateFormat(String pattern) {
        DateFormat df = new SimpleDateFormat(pattern);
        df.setLenient(false);
        return df;
    }

    /**
     * @param date
     * @param format
     * @return
     */
    public static String format(Date date, String format) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * @param sDate
     * @return
     * @throws ParseException
     */
    public static Date parseDateNoTime(String sDate) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(shortFormat);
        if ((sDate == null) || (sDate.length() < shortFormat.length())) {
            throw new ParseException("length too little", 0);
        }
        if (!StringUtils.isNumeric(sDate)) {
            throw new ParseException("not all digit", 0);
        }
        return dateFormat.parse(sDate);
    }

    /**
     * @param sDate
     * @param format
     * @return
     * @throws ParseException
     */
    public static Date parseDateNoTime(String sDate, String format) throws ParseException {
        if (StringUtils.isBlank(format)) {
            throw new ParseException("Null format. ", 0);
        }
        DateFormat dateFormat = new SimpleDateFormat(format);
        if ((sDate == null) || (sDate.length() < format.length())) {
            throw new ParseException("length too little", 0);
        }
        return dateFormat.parse(sDate);
    }

    /**
     * @param sDate
     * @param delimit
     * @return
     * @throws ParseException
     */
    public static Date parseDateNoTimeWithDelimit(String sDate, String delimit) throws ParseException {
        sDate = sDate.replaceAll(delimit, "");
        DateFormat dateFormat = new SimpleDateFormat(shortFormat);
        if ((sDate == null) || (sDate.length() != shortFormat.length())) {
            throw new ParseException("length not match", 0);
        }
        return dateFormat.parse(sDate);
    }

    /**
     * @param sDate
     * @return
     */
    public static Date parseDateLongFormat(String sDate) {
        DateFormat dateFormat = new SimpleDateFormat(longFormat);
        Date d = null;
        if ((sDate != null) && (sDate.length() == longFormat.length())) {
            try {
                d = dateFormat.parse(sDate);
            } catch (ParseException ex) {
                return null;
            }
        }
        return d;
    }

    /**
     * @param sDate
     * @return
     */
    public static Date parseDateNewFormat(String sDate) {
        DateFormat dateFormat = new SimpleDateFormat(newFormat);
        Date d = null;
        dateFormat.setLenient(false);
        if ((sDate != null) && (sDate.length() == newFormat.length())) {
            try {
                d = dateFormat.parse(sDate);
            } catch (ParseException ex) {
                return null;
            }
        }
        return d;
    }

    /**
     * 计算当前时间几小时之后的时间
     *
     * @param date
     * @param hours
     * @return
     */
    public static Date addHours(Date date, long hours) {
        return addMinutes(date, hours * 60);
    }

    /**
     * 计算当前时间几分钟之后的时间
     *
     * @param date
     * @param minutes
     * @return
     */
    public static Date addMinutes(Date date, long minutes) {
        return addSeconds(date, minutes * 60);
    }

    /**
     * @param date1
     * @param secs
     * @return
     */
    public static Date addSeconds(Date date1, long secs) {
        return new Date(date1.getTime() + (secs * 1000));
    }

    /**
     * 判断输入的字符串是否为合法的小时
     * @param hourStr
     * @return true/false
     */
    public static boolean isValidHour(String hourStr) {
        if (!StringUtils.isEmpty(hourStr) && StringUtils.isNumeric(hourStr)) {
            int hour = new Integer(hourStr).intValue();
            if ((hour >= 0) && (hour <= 23)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 取得新的日期
     * @param date1 日期
     * @param days 天数
     * @return 新的日期
     */
    public static Date addDays(Date date1, long days) {
        return addSeconds(date1, days * ONE_DAY_SECONDS);
    }

    /**
     * @param date
     * @return
     */
    public static String getLongDateString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat(longFormat);
        return getDateString(date, dateFormat);
    }

    /**
     * @param date
     * @return
     */
    public static String getNewFormatDateString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat(newFormat);
        return getDateString(date, dateFormat);
    }

    /**
     * @param date
     * @param dateFormat
     * @return
     */
    public static String getDateString(Date date, DateFormat dateFormat) {
        if (date == null || dateFormat == null) {
            return null;
        }
        return dateFormat.format(date);
    }

    /**
     * @return 当天的时间格式化为"yyyyMMdd"
     */
    public static String getDateString(Date date) {
        DateFormat df = getNewDateFormat(shortFormat);
        return df.format(date);
    }

    /**
     * @param date
     * @return
     */
    public static String getWebDateString(Date date) {
        DateFormat dateFormat = getNewDateFormat(webFormat);
        return getDateString(date, dateFormat);
    }

    /**
     * 取得“X年X月X日”的日期格式
     *
     * @param date
     * @return
     */
    public static String getChineseDateString(Date date) {
        DateFormat dateFormat = getNewDateFormat(chineseDtFormat);
        return getDateString(date, dateFormat);
    }

    /**
     * @return
     */
    public static String getTodayString() {
        DateFormat dateFormat = getNewDateFormat(shortFormat);
        return getDateString(new Date(), dateFormat);
    }

    /**
     * @param date
     * @return
     */
    public static String getTimeString(Date date) {
        DateFormat dateFormat = getNewDateFormat(timeFormat);
        return getDateString(date, dateFormat);
    }

    /**
     * @param days
     * @return
     */
    public static String getBeforeDayString(int days) {
        Date date = new Date(System.currentTimeMillis() - (ONE_DAY_MILL_SECONDS * days));
        DateFormat dateFormat = getNewDateFormat(shortFormat);
        return getDateString(date, dateFormat);
    }

    /**
     * 取得两个日期间隔秒数（日期1-日期2）
     *
     * @param one 日期1
     * @param two 日期2
     * @return 间隔秒数
     */
    public static long getDiffSeconds(Date one, Date two) {
        Calendar sysDate = new GregorianCalendar();
        sysDate.setTime(one);
        Calendar failDate = new GregorianCalendar();
        failDate.setTime(two);
        return (sysDate.getTimeInMillis() - failDate.getTimeInMillis()) / 1000;
    }

    /**
     * @param one
     * @param two
     * @return
     */
    public static long getDiffMinutes(Date one, Date two) {
        Calendar sysDate = new GregorianCalendar();
        sysDate.setTime(one);
        Calendar failDate = new GregorianCalendar();
        failDate.setTime(two);
        return (sysDate.getTimeInMillis() - failDate.getTimeInMillis()) / (60 * 1000);
    }

    /**
     * 取得两个日期的间隔天数
     *
     * @param one
     * @param two
     * @return 间隔天数
     */
    public static long getDiffDays(Date one, Date two) {
        Calendar sysDate = new GregorianCalendar();
        sysDate.setTime(one);
        Calendar failDate = new GregorianCalendar();
        failDate.setTime(two);
        return (sysDate.getTimeInMillis() - failDate.getTimeInMillis()) / (24 * 60 * 60 * 1000);
    }

    /**
     * @param sDate
     * @return
     * @throws ParseException
     */
    public static Date parseNoSecondFormat(String sDate) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(noSecondFormat);

        if ((sDate != null) && (sDate.length() == noSecondFormat.length())) {
            return dateFormat.parse(sDate);
        }
        return null;
    }
}
