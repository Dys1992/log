package com.ymm.info.logplatform.biz.mapper.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ymm.info.logplatform.commom.util.DateUtil;
import org.springframework.stereotype.Component;

/**
 * @author wuyayuan
 * @version Id: LogMapper, v 0.1 2018/8/14 14:55 wuyayuan Exp $
 */
@Component
public class FullDateConverter {

    public FullDateConverter() {
    }

    public String asString(Long date) {
        return date != null ? (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(date) : null;
    }

    public Long toDateTime(String date) {
        return DateUtil.parseDateNewFormat(date).getTime();
    }

}