package com.mobiusVision.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: zhangzhirong
 * @Description:日期相关工具类
 * @Date:Created in 9:30 2018/6/25/025
 * @Modify By:
 **/
public class DateUtil {

    public static int getDaysOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    //获取那年那月的天数
    public static int getDays(String formatDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        try {
            return getDaysOfMonth(sdf.parse(formatDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 31;
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(getDays("20172"));
    }
}
