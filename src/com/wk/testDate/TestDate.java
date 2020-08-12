package com.wk.testDate;

import org.junit.Test;

import javax.swing.plaf.OptionPaneUI;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjusters;

/**
 * @author WK
 * @create 2020-08-10-21:51
 */
public class TestDate {
    @Test
    public void test1(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.plusYears(1));
        System.out.println(now.minusYears(1));
        System.out.println(now.getMonthValue());
        System.out.println(now.getDayOfYear());
    }

    /**
     * 时间戳，以1970开始
     */
    @Test
    public void test2(){
        Instant now = Instant.now();
        System.out.println(now);
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        System.out.println(now.toEpochMilli());
        System.out.println(Instant.ofEpochSecond(60));
    }

    /**
     * 计算两个时间间隔
     */
    @Test
    public void test3(){
        Instant now = Instant.now();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant now1 = Instant.now();
        Duration between = Duration.between(now, now1);
        System.out.println(now);
        System.out.println(between.toMillis());
        System.out.println(LocalDateTime.now().getSecond());
        System.out.println(now.toEpochMilli()+"  "+System.currentTimeMillis());
    }
    /**
     * 时间矫正器
     */
    @Test
    public void test4(){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = now.withDayOfMonth(5);
        System.out.println(localDateTime);
        LocalDateTime with = now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(with);
        now.with((x) -> {
            LocalDateTime x1 = (LocalDateTime)x;
            DayOfWeek dayOfWeek = x1.getDayOfWeek();
            return x;
        });
    }
    /**
     * 时区时间
     */
    @Test
    public void test5(){
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime zonedDateTime = now.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(now);
        System.out.println(zonedDateTime);
    }
    /**
     * DatetimeFormat
     */
    @Test
    public void test6(){
        DateTimeFormatter isoDate = DateTimeFormatter.ISO_DATE;
        LocalDateTime now = LocalDateTime.now();
        String format = now.format(isoDate);
        System.out.println(format);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        System.out.println(now.format(dateTimeFormatter));
        LocalDateTime parse = now.parse(now.format(dateTimeFormatter), dateTimeFormatter);
        System.out.println(parse);
        //1111
        //
    }

}
