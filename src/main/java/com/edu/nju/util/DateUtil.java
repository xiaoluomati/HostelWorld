package com.edu.nju.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhuding on 2017/3/7.
 */
public class DateUtil {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private DateUtil() {
    }

    public static String dateToString(Date date) {
        String result = null;
        try {
            result = DATE_FORMAT.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean isAfter(String string1, String string2) {
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = DATE_FORMAT.parse(string1);
            date2 = DATE_FORMAT.parse(string2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1.after(date2);
    }

}
