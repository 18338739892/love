package com.pkk.utils.common;


import org.apache.log4j.MDC;

/**
 * @author peikunkun
 * @version V1.0
 * @Title: love
 * @Package com.pkk.utils.common
 * @Description: <>
 * @date 11/16 0016 14:34
 */
@SuppressWarnings(value = "all")
public class LoggerUtilMDC extends LoggerUtil {

    /**
     * *************************************************************************
     *
     * @param
     * @return void
     * @Description: <数据库操作日志时增加字段属性>
     * @author peikunkun
     * @date 2017年11/16 0016 14:42
     * @version V1.0
     * *************************************************************************
     */
    public static void put(String key, String value) throws NullPointerException {

        if (key == null || key.length() <= 0) {
            throw new NullPointerException();
        }
        //使用前先移除
        if (MDC.get(key) != null) {
            MDC.remove(key);
        }
        MDC.put(key, value);
    }

    /**
     * *************************************************************************
     *
     * @param
     * @return void
     * @Description: <指定操纵者>
     * @author peikunkun
     * @date 2017年11/16 0016 14:47
     * @version V1.0
     * *************************************************************************
     */
    public static void putName(String value) {
        //使用前先移除
        if (MDC.get("name") != null) {
            MDC.remove("name");
        }
        MDC.put("name", value);
    }

    /**
     * *************************************************************************
     *
     * @param
     * @return void
     * @Description: <清除数据库要填充的所有的字段
     * @author peikunkun
     * @date 2017年11/16 0016 14:43
     * @version V1.0
     * *************************************************************************
     */
    public static void clearAll() throws Exception {
        MDC.clear();
    }
}
