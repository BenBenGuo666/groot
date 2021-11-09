package com.xwtech.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author guoxiang
 * @date 2019-11-02 00:45
 **/
public class DateUtils {

    /**
     * 获取两个日期间隔的所有日期
     *
     * @param start 格式必须为'yyyy-mm-dd'
     * @param end   格式必须为'yyyy-mm-dd'
     * @return
     */
    public static List<String> getBetweenDate(String start, String end) {
        List<String> dateList = new ArrayList<>();
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        long distance = ChronoUnit.DAYS.between(startDate, endDate);
        if (distance < 1) {
            dateList.add(start);
            return dateList;
        }
        Stream.iterate(startDate, d -> d.plusDays(1)).limit(distance + 1).forEach(f -> dateList.add(f.toString()));
        return dateList;
    }

    /**
     * 获取时间中的小时
     *
     * @param dateStr 2019-11-17 01:00:00"
     * @return
     */
    public static int getHour(String dateStr) {
        return LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).getHour();
    }

    public static String format(Date date) {
        String format = "yyyy-MM-dd HH:mm:ss";
        return new SimpleDateFormat(format).format(date);
    }

    public static String format(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    public static void main(String[] args) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2021-07-01 12:21:30");
        System.out.println(format(date, "yyyyMMddHHmmss"));
    }
}
