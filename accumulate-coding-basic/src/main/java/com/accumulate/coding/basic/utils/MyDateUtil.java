package com.accumulate.coding.basic.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Date:  2020/10/16
 * Todo: handle Date and Time
 * Time 10:12
 * From https://mp.weixin.qq.com/s?__biz=MjM5NzMyMjAwMA==&mid=2651490612&idx=1&sn=2d852df19613b184b97473df4a83301f&chksm=bd25e54b8a526c5dfb59c51879ed015514637b5f289a3ed793289e9aead146c30451157abaed&scene=126&sessionid=1602813144&key=bd8ad81032fdfaf2a92e48b99dc14bbd0026c09146aa33cb71b42685bc857377a8c5c9c3a95e1719497c723baa593ad594d072562ef707b4c5753741672cafd23e1679a12a85b4fe6abc63b9657aa91ff087edec01ead5fa108a921b3c88b040725b072cb725ca1554302bcd7a66f0dba716172b697274026dcc1caa787ec9c3&ascene=1&uin=MTY3NzY3NzY0Mg%3D%3D&devicetype=Windows+10+x64&version=6300002f&lang=zh_CN&exportkey=AWhywN6yQHMw1BN32FLiVa4%3D&pass_ticket=id7h731ndjlgKBHBdBlBV46x%2BKd4B2bRkbjjks3%2F42xqgLNX6NPE9qo2hM0kTcA%2F&wx_header=0
 */
public class MyDateUtil {

    //format Date
    private static DateTimeFormatter dateFormatter = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd");

    //format Time
    private static DateTimeFormatter timeFormatter = java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss");

    //format @DateTime
    private static DateTimeFormatter DateTimeFormatter = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * get Date with year、month、day
     *
     * @param year
     * @param month
     * @param day
     * @return string of date
     */
    public static String getDate(Integer year, Integer month, Integer day) {
        LocalDate localDate = LocalDate.of(day, month, day);
        return localDate.format(dateFormatter);
    }

    /**
     * get Time with hour、minute、second
     *
     * @param hour
     * @param minute
     * @param second
     * @return string of time
     */
    public static String getTime(Integer hour, Integer minute, Integer second) {
        LocalTime localTime = LocalTime.of(hour, minute, second);
        return localTime.format(timeFormatter);
    }

    /**
     * get date and time with year/month/day/hour/minute/second
     *
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     * @param second
     * @return string of @DateTime
     */
    public static String getDateTime(Integer year, Integer month, Integer day, Integer hour, Integer minute, Integer second) {
        LocalDate localDate = LocalDate.of(year, month, day);
        LocalTime localTime = LocalTime.of(hour, minute, second);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        return localDateTime.format(DateTimeFormatter);
    }

}
