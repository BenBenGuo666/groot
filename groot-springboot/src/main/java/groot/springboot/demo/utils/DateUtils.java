package groot.springboot.demo.utils;

import cn.hutool.core.date.LocalDateTimeUtil;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author zongyuqiang
 */
@Slf4j
public class DateUtils {

    public static final DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * @param localDateTime yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String dateTimeToString(LocalDateTime localDateTime) {
        return dateTimeToString(localDateTime, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * @param localDateTime
     * @param format
     * @return
     */
    public static String dateTimeToString(LocalDateTime localDateTime, String format) {
        try {
            if (null == localDateTime){
                return null;
            }
            return DateTimeFormatter.ofPattern(format).format(localDateTime);
        } catch (Throwable e) {
            log.error("时间格式化失败:{}", e.getCause());
            e.getMessage();
        }
        return null;
    }

    public static String dateTimeToString(ZonedDateTime zonedDateTime, String format) {
        try {
            if (null == zonedDateTime){
                return null;
            }
            return DateTimeFormatter.ofPattern(format).format(zonedDateTime);
        } catch (Throwable e) {
            log.error("时间格式化失败:{}", e.getCause());
            e.getMessage();
        }
        return null;
    }

    public static long dateTimeToMilli(LocalDateTime localDateTime) {
        return localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    public static long getCurrentDayTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }


    /**
     * 返回时间的年月日格式 yyyy-mm-dd
     *
     * @param dateTime
     * @return
     */
    public static String timeToString(LocalDateTime dateTime) {
        String string = dateTime.toString();
        String[] ts = string.split("T");
        return ts[0];
    }

    public static String format(Date date) {
        try {
            if (null == date){
                return null;
            }
            String format = "yyyy-MM-dd HH:mm:ss";
            return new SimpleDateFormat(format).format(date);
        } catch (Throwable e) {
            log.error("时间格式化失败:{}", e.getCause());
            e.getMessage();
        }
        return null;
    }

    public static String format(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    public static long timeDifference(LocalDateTime future, LocalDateTime now) {
        if (future == null || now == null) {
            return 0L;
        }
        long result = DateUtils.dateTimeToMilli(future) - DateUtils.dateTimeToMilli(now);
        return result;
    }

    /**
     * 判断时间范围
     *
     * @param dateTime
     * @return
     */
    public static long intervalDay(LocalDateTime dateTime) {
        LocalDateTime now = LocalDateTime.now();
        //当前日期减去传入日期的天数
        Duration between = LocalDateTimeUtil.between(dateTime, now);
        //相差的时间间隔天数为：
        long betweenDays = between.toDays();
        return betweenDays;
    }

    /**
     * 判断时间范围
     *
     * @param dateTime
     * @return
     */
    public static long intervalDay(LocalDateTime dateTime, LocalDateTime now) {
        //当前日期减去传入日期的天数
        Duration between = LocalDateTimeUtil.between(dateTime, now);
        //相差的时间间隔天数为：
        long betweenDays = between.toDays();
        return betweenDays;
    }

    /**
     * 转为date类型
     *
     * @param time
     * @return
     */
    public static Date locToDate(LocalDateTime time) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = time.atZone(zone).toInstant();
        Date date = Date.from(instant);
        return date;
    }

    /**
     * 最近的五分钟
     *
     * @param dateTime
     * @return
     */
    public static LocalDateTime getNear5(LocalDateTime dateTime) {
        if (null == dateTime) {
            return null;
        }
        Integer minute = dateTime.getMinute();
        minute = minute / 5 * 5;
        return LocalDateTime.of(dateTime.getYear(),
                dateTime.getMonth(),
                dateTime.getDayOfMonth(),
                dateTime.getHour(),
                minute, 0);
    }

    /**
     * @param now
     * @return
     */
    public static Long getNear5(Long now) {
        if (now == null) {
            return null;
        }
        return now - (1000L * 60L * 5l);
    }

    /**
     * @param now
     * @param x   x 分钟
     * @return
     */
    public static Long getNearX(Long now, long x) {
        if (now == null) {
            return null;
        }
        return now - (1000L * 60L * x);
    }

    /**
     * @param now
     * @param x   x 分钟
     * @return
     */
    public static Long getNextX(Long now, long x) {
        if (now == null) {
            return null;
        }
        return now + (1000L * 60L * x);
    }

    /**
     * @param now
     * @param x   x 分钟
     * @return
     */
    public static Long getNearMinute(Long now, long x) {
        if (now == null) {
            return null;
        }
        return now - (1000L * 60L * x);
    }

    /**
     * @param now
     * @param x   x 分钟
     * @return
     */
    public static Long getNextMinute(Long now, long x) {
        if (now == null) {
            return null;
        }
        return now + (1000L * 60L * x);
    }


    public static LocalDateTime longToTime(Long time) {
        if (time == null) {
            return null;
        }
        return LocalDateTime.ofEpochSecond(time / 1000, 0, ZoneOffset.ofHours(8));
    }

    /**
     * 获取当天最小时间 00:00:00
     * @param localDateTime
     * @return
     */
    public static LocalDateTime getDayBegin(LocalDateTime localDateTime) {
        return LocalDateTime.of(localDateTime.getYear(),
                localDateTime.getMonth(),
                localDateTime.getDayOfMonth(),
                0,
                0,
                0);
    }

    /**
     * 获取当天最大时间 23:59:59
     * @param localDateTime
     * @return
     */
    public static LocalDateTime getDayEnd(LocalDateTime localDateTime) {
        return LocalDateTime.of(localDateTime.getYear(),
                localDateTime.getMonth(),
                localDateTime.getDayOfMonth(),
                23,
                59,
                59);
    }

    /**
     * 获取本周开始时间 00:00:00
     * @return
     */
    public static LocalDateTime getWeekBegin() {
        LocalDate todayNow = LocalDate.now();
        DayOfWeek week = todayNow.getDayOfWeek();
        int value = week.getValue();
        LocalDate startDate = todayNow.minusDays(value-1);
        return getDayBegin(startDate.atStartOfDay());
    }

    /**
     * 获取本周结束时间 23:59:59
     * @return
     */
    public static LocalDateTime getWeekEnd() {
        LocalDate todayDate = LocalDate.now();
        DayOfWeek week = todayDate.getDayOfWeek();
        int value = week.getValue();
        LocalDate weekEndDate = todayDate.plusDays(7-value);
        return getDayEnd(weekEndDate.atStartOfDay());
    }

    /**
     * 获取当月开始时间 00:00:00
     * @return
     */
    public static LocalDateTime getMonthBegin() {
        LocalDateTime now = LocalDateTime.now();
        return getDayBegin(now.with(TemporalAdjusters.firstDayOfMonth()));
    }

    /**
     * 获取当月结束时间 23:59:59
     * @return
     */
    public static LocalDateTime getMonthEnd() {
        LocalDateTime now = LocalDateTime.now();
        return getDayEnd(now.with(TemporalAdjusters.lastDayOfMonth()));
    }

    /**
     * 获取某年最后结束时间 23:59:59
     * @param yearNum
     * @return
     */
    public static LocalDateTime getYearEnd(int yearNum) {
        LocalDateTime now = LocalDateTime.now();
        return getDayEnd(now.plusYears(yearNum).with(TemporalAdjusters.lastDayOfYear()));
    }

    /**
     * 解析字符串为日期
     *
     * 说明：
     * 1. 该方法主要解决yyyy-MM-dd格式文本字符串无法直接转换为LocalDateTime的问题
     *
     * @param source 需要解析的日期字符串
     * @param formatPattern 日期格式化模式
     * @return 格式化后的日期
     */
    public static LocalDateTime parseStringToLocalDateTime(String source, String formatPattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(formatPattern);
        LocalDate localDate = LocalDate.parse(source, dateTimeFormatter);
        return localDate.atStartOfDay();

    }

    public static void main(String[] args) {
        // 可以根据需要指定特定的时区
        List<LocalDate> dateList = IntStream.range(0, 7)
                .mapToObj(i -> LocalDate.now().minus(i, ChronoUnit.DAYS))
                .collect(Collectors.toList());

        dateList.forEach(System.out::println);
    }

}
