package Tools;

import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.Recur;
import net.fortuna.ical4j.model.WeekDay;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.UUID;
import net.fortuna.ical4j.model.TimeZone;
import net.fortuna.ical4j.model.TimeZoneRegistry;
import net.fortuna.ical4j.model.TimeZoneRegistryFactory;
public class IcsGenerator {

    public static void generateICS(String summary, String location, Date startDate, Date endDate, String dayOfWeek, Date startTime, Date endTime, String outputFileName) throws ParseException, IOException {
        // 创建一个iCalendar对象
        System.setProperty("net.fortuna.ical4j.timezone.cache.impl", "net.fortuna.ical4j.util.MapTimeZoneCache");
        System.out.println("dayOfWeek::"+dayOfWeek);
        Calendar calendar = new Calendar();

        // 添加版本信息
        calendar.getProperties().add(Version.VERSION_2_0);

        // 根据星期名称得到相应的数字
        int dayOfWeekNumber = mapDayOfWeekToNumber(dayOfWeek);

        // 创建一个PRODID属性（表示产品标识）
        ProdId prodId = new ProdId("-//Cookie//groupwork1//EN");
        calendar.getProperties().add(prodId);

        // 设定时区为 Boston (America/New_York)
        TimeZoneRegistry registry = TimeZoneRegistryFactory.getInstance().createRegistry();
        TimeZone timeZone = registry.getTimeZone("America/New_York");
        // 组合 startDate 和 startTime 以及 startDate 和 endTime
        java.util.Calendar combinedStartCal = java.util.Calendar.getInstance(timeZone);
        combinedStartCal.setTime(startDate);
        java.util.Calendar startTimeCal = java.util.Calendar.getInstance(timeZone);
        startTimeCal.setTime(startTime);
        combinedStartCal.set(java.util.Calendar.HOUR_OF_DAY, startTimeCal.get(java.util.Calendar.HOUR_OF_DAY));
        combinedStartCal.set(java.util.Calendar.MINUTE, startTimeCal.get(java.util.Calendar.MINUTE));
        combinedStartCal.set(java.util.Calendar.SECOND, startTimeCal.get(java.util.Calendar.SECOND));

        java.util.Calendar combinedEndCal = java.util.Calendar.getInstance(timeZone);
        combinedEndCal.setTime(startDate);
        java.util.Calendar endTimeCal = java.util.Calendar.getInstance(timeZone);
        endTimeCal.setTime(endTime);
        combinedEndCal.set(java.util.Calendar.HOUR_OF_DAY, endTimeCal.get(java.util.Calendar.HOUR_OF_DAY));
        combinedEndCal.set(java.util.Calendar.MINUTE, endTimeCal.get(java.util.Calendar.MINUTE));
        combinedEndCal.set(java.util.Calendar.SECOND, endTimeCal.get(java.util.Calendar.SECOND));

        // 使用组合的日期时间创建 VEvent
        DateTime startDateTime = new DateTime(combinedStartCal.getTime());
        startDateTime.setTimeZone(timeZone);
        DateTime endDateTime = new DateTime(combinedEndCal.getTime());
        endDateTime.setTimeZone(timeZone);
        VEvent event = new VEvent(startDateTime, endDateTime, summary);


        // 设置事件的地点
        Location locationProp = new Location(location);
        event.getProperties().add(locationProp);

        // 设置事件的重复规则（每周）
        Recur recur = new Recur(Recur.WEEKLY, new net.fortuna.ical4j.model.Date(endDate));
        recur.getDayList().add(WeekDay.getDay(dayOfWeekNumber));
        RRule rule = new RRule(recur);
        event.getProperties().add(rule);

        // 为事件生成一个唯一的UID
        Uid uid = new Uid(UUID.randomUUID().toString());
        event.getProperties().add(uid);

        // 将事件添加到iCalendar对象中
        calendar.getComponents().add(event);

        // 输出ICS文件到指定路径
        CalendarOutputter outputter = new CalendarOutputter();
        try (FileOutputStream fileOutputStream = new FileOutputStream(outputFileName)) {
            outputter.output(calendar, fileOutputStream);
        }
    }

    private static int mapDayOfWeekToNumber(String dayOfWeek) {
        switch (dayOfWeek) {
            case "Monday":
                return 2;
            case "Tuesday":
                return 3;
            case "Wednesday":
                return 4;
            case "Thursday":
                return 5;
            case "Friday":
                return 6;
            case "Saturday":
                return 7;
            case "Sunday":
                return 1;
            default:
                return 0; // 0 表示错误
        }
    }
}
