package com.pkk.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by peikunkun on 2017/10/22 0022.
 */
public class DateUtils {

    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("");
        }
    };

    /**
     * <p>Title: stringToDate</p>
     * <p>Description: 日期的转换</p>
     * <p>Copyright: Copyright (c) 2017</p>
     *
     * @author pkk
     * @date 2017/10/22 0022
     * @version 1.0
     */
    public static Date stringToDate(String dateTemp, String pattern) {

        return  null;
    }


}
