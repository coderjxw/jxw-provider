package com.example.jxw.utils;

import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeUtils {
    private static final ZoneId CHINA_TIMEZONE = ZoneId.of("Asia/Shanghai");
    private static final int MILLISECONDS_DEFINITION_OF_CLOSE = 1000;
    private static final double MILLISECONDS_IN_ONE_DAY = 24 * 60 * 60 * 1000.00;
    private static final ZoneOffset CHINA_OFFSET = ZoneOffset.of("+8");
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    public static final TimeZone DEFAULT_TIMEZONE = TimeZone.getTimeZone("UTC");
    private static final FastDateFormat DATE_FORMAT_UTC = FastDateFormat.getInstance("yyyy-MM-dd", DEFAULT_TIMEZONE);
    public static final TimeZone CHINA_TIME_ZONE = TimeZone.getTimeZone("GMT+08:00");
    private static final FastDateFormat DATE_FORMAT_CHINA = FastDateFormat.getInstance("yyyy-MM-dd", CHINA_TIME_ZONE);

    public static boolean isClose(Date time1, Date time2) {
        return Math.abs(time1.getTime() - time2.getTime()) < MILLISECONDS_DEFINITION_OF_CLOSE;
    }

    public static Long getCurrentTimesNight(Long time) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(time));
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.DAY_OF_YEAR, 1);
        return cal.getTime().getTime();
    }

    public static Long getDurationDays(Date dateFrom, Date dateTo) {
        Double durationMills = Math.ceil((dateTo.getTime() - dateFrom.getTime()) / MILLISECONDS_IN_ONE_DAY);
        return durationMills.longValue();
    }

    public static Long getTodayBeginningTimeStamp() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTimeInMillis();
    }

    public static Long getTodayBeijingTimeStamp() {
        return LocalDateTime.now(CHINA_TIMEZONE).toInstant(CHINA_OFFSET).toEpochMilli();
    }

    public static String formatBeijingTime(Long epochSeconds) {
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(epochSeconds, 0, CHINA_OFFSET);
        return localDateTime.format(DATE_TIME_FORMATTER);
    }

    public static String parseTimeToHourAndMinutes(Long startTime) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        format.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        return format.format(new Date(startTime));
    }

    public static void setCalendarNoMill(Calendar calendar, int year, int month, int date, int hourOfDay, int minute,
                                         int second) {
        calendar.set(year, month, date, hourOfDay, minute, second);
        calendar.set(Calendar.MILLISECOND, 0);
    }

    public static LocalDateTime getLocalDateTime(Long epochSeconds) {
        return LocalDateTime.ofEpochSecond(epochSeconds, 0, CHINA_OFFSET);
    }

    public static Date parseUtcDate(String date) throws ParseException {
        return DATE_FORMAT_UTC.parse(date);
    }

    public static Date parseChinaDate(String date) throws ParseException {
        return DATE_FORMAT_CHINA.parse(date);
    }

    public static LocalDateTime getTodayBeijingLocalDateTime() {
        return LocalDateTime.now(CHINA_TIMEZONE);
    }

    private TimeUtils() {
        throw new IllegalStateException("Utility class");
    }
}
