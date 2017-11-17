package com.pkk.test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author peikunkun
 * @version V1.0
 * @Title: love
 * @Package com.pkk.test
 * @Description: <>
 * @date 11/17 0017 17:13
 */
public class Test1 {


    private static final String PARAM_STRING_COMPILE = ":[\\S]+";

    public String getParamString(String ql) {
        Pattern p = Pattern.compile(PARAM_STRING_COMPILE);
        // 创建 Matcher 对象
        Matcher m = p.matcher(ql);
        // 是否找到匹配
        boolean found = m.find();
        if (found) {
            String g = m.group();
            return g.substring(1, g.length());
        }
        return "";
    }


    public static void main(String[] args) {
        System.out.println(new Test1().getParamString("select 1 where a=:a and b=:b"));
    }


    public void mergeQl(StringBuffer ql, String appendql, Object value, List<String> params, List<Object> values) {
        if (value == null) {
            return;
        }
        if (value instanceof String) {
            if (value == null || ((String) value).length() <= 0 || value.toString().equals("%") || value.toString().equals("%%")) {
                return;
            }
            ql.append(appendql);
            params.add(getParamString(appendql));
            values.add(value.toString().trim());
        } else {
            ql.append(appendql);
            params.add(getParamString(appendql));
            values.add(value);
        }
    }


}
