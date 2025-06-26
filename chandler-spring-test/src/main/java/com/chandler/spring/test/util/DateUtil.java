package com.chandler.spring.test.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 类功能描述
 *
 * @author 钱丁君-chandler 2023/8/16 09:00
 * @since 1.8
 */
public class DateUtil {
  public static String formatHourMinute = "HH:mm";
  public static String formatNo = "yyyyMMddHHmmss";
  public static String formatDate = "yyyy-MM-dd";
  public static String formatTime = "yyyy-MM-dd HH:mm:ss";
  public static SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(formatDate);
  public static SimpleDateFormat TIME_FORMATTER = new SimpleDateFormat(formatTime);
  public static SimpleDateFormat DAY_START_DATE_FORMATTER =
      new SimpleDateFormat("yyyy-MM-dd 00:00:00");
  public static SimpleDateFormat DAY_END_DATE_FORMATTER =
      new SimpleDateFormat("yyyy-MM-dd 00:00:00");

  public static Date getDayStartTime() {
    return getDayStartTime(new Date());
  }

  public static Date getDayStartTime(Date date) {
    String format = DAY_START_DATE_FORMATTER.format(date);
    return stringToDay(format);
  }

  public static String getDayNo() {
    return getDayNo(new Date());
  }

  public static String getDayNo(Date date) {
    SimpleDateFormat dateFormat = new SimpleDateFormat(formatNo);
    return dateFormat.format(date);
  }

  public static Date stringToDayNo(String format) {
    SimpleDateFormat dateFormat = new SimpleDateFormat(formatNo);
    try {
      return dateFormat.parse(format);
    } catch (ParseException e) {
      throw new RuntimeException(String.format("获取%s时间发生异常！", format), e);
    }
  }

  public static Date getDayEndTime() {
    return getDayEndTime(new Date());
  }

  public static Date getDayEndTime(Date date) {
    String format = DAY_END_DATE_FORMATTER.format(date);
    return stringToDay(format);
  }

  public static Date getDayMinutes(String format) {
    SimpleDateFormat dateFormat = new SimpleDateFormat(formatHourMinute);
    try {
      return dateFormat.parse(format);
    } catch (ParseException e) {
      throw new RuntimeException(String.format("获取%s时间发生异常！", format), e);
    }
  }

  public static String getDayMinutesStr(Date date) {
    SimpleDateFormat dateFormat = new SimpleDateFormat(formatHourMinute);
    return dateFormat.format(date);
  }

  public static long getNumber(String time) {
    Date time0 = getDayMinutes("00:00");
    Date time1 = getDayMinutes(time);
    long duration = time1.getTime() - time0.getTime();
    return duration / (30 * 60 * 1000);
  }

  public static String formatDate0 = "yyyy-MM-dd";
  public static String formatDate2 = "yyyy/MM/dd";
  public static String formatDate3 = "yyyy/M/d";
  public static String formatTime0 = "yyyy-MM-dd HH:mm:ss";
  public static String formatTime2 = "yyyy/MM/dd HH:mm:ss";
  public static String formatTime3 = "yyyy/M/d HH:mm:ss";

  public static Date stringToDay(String format) {
    format = format.trim();
    String f = formatTime0;
    if (formatTime0.length() == format.length()) {
      if (format.contains("/")) {
        f = formatTime2;
      }
    } else if (formatDate0.length() == format.length()) {
      f = formatDate0;
      if (format.contains("/")) {
        f = formatDate2;
      }
    } else if (formatDate.length() < format.length() && format.length() < formatTime0.length()) {
      f = formatTime3;
    } else if (format.length() < formatDate.length()) {
      f = formatDate3;
    }
    SimpleDateFormat dateFormat = new SimpleDateFormat(f);
    try {
      return dateFormat.parse(format);
    } catch (ParseException e) {
      throw new RuntimeException(String.format("获取%s时间发生异常！", format), e);
    }
  }

  public static Date append(String first, String second, String third) {
    return stringToDay(String.format("%s%s:%s", first, second, third));
  }

  public static void main(String[] args) {
    Date date = stringToDayNo("20240829113212");
    String str = TIME_FORMATTER.format(date);
    System.out.println(str);
  }
}
