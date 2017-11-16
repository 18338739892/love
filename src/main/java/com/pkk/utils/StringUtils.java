package com.pkk.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Async;

import com.pkk.utils.constant.SysConstant;

/**
 * @author peikunkun
 * @version V1.0
 * @Title: love
 * @Package com.pkk.utils
 * @Description: <工具类>
 * @date 11/16 0016 18:27
 */
public class StringUtils {

    /**
     * @Title: getDateStr<br>
     * @Description: <获取标准格式的时间字符串><br>
     * @author peikunkun<br>
     * @date 2017年11/16 0016 18:34<br>
     * @version V1.0<br>
     */
    public synchronized static String getDateStr(Date date) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SysConstant.DATEFORMAT);
        String dateStr = "";
        if (date == null) {
            dateStr = simpleDateFormat.format(new Date());
        } else {
            dateStr = simpleDateFormat.format(dateStr);
        }
        return dateStr;
    }

    /**
     * @Title: getDateStr<br>
     * @Description: <获取标准格式的时间字符串><br>
     * @author peikunkun<br>
     * @date 2017年11/16 0016 18:34<br>
     * @version V1.0<br>
     */
    public synchronized static String getDateStr() {
        return getDateStr(null);
    }


}
