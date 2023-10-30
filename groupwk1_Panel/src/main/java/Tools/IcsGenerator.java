package Tools;
import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.model.*;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
public class IcsGenerator {

    public static void generateICS(String summary, String location, Date startDate, Date endDate, String dayOfWeek, Date startTime, Date endTime, String outputFileName) throws ParseException, IOException {
        Calendar calendar = new Calendar();

        // 映射星期几到数字
        int dayOfWeekNumber = mapDayOfWeekToNumber(dayOfWeek);
        // Create a PRODID property with a unique identifier
        ProdId prodId = new ProdId("-//YourOrganization//YourApp//EN");
        calendar.getProperties().add(prodId);

        // 创建事件
        VEvent event = new VEvent(new DateTime(startDate), new DateTime(endDate), summary);

        // 设置事件的位置
        Location locationProp = new Location(location);
        event.getProperties().add(locationProp);

        // 设置事件的重复规则
        Recur recur = new Recur(Recur.WEEKLY, 1);
        recur.getDayList().add(WeekDay.getDay(dayOfWeekNumber));
        RRule rule = new RRule(recur);
        event.getProperties().add(rule);

        // 设置事件的时间段
        event.getProperties().add(new DtStart(new DateTime(startTime)));
        event.getProperties().add(new DtEnd(new DateTime(endTime)));

        calendar.getComponents().add(event);

        // 输出ICS文件
        CalendarOutputter outputter = new CalendarOutputter();
        FileOutputStream fileOutputStream = new FileOutputStream(outputFileName);
        outputter.output(calendar, fileOutputStream);
        fileOutputStream.close();
    }
    private static int mapDayOfWeekToNumber(String dayOfWeek) {
        // 映射星期几到数字
        switch (dayOfWeek) {
            case "Monday":
                return 1;
            case "Tuesday":
                return 2;
            case "Wednesday":
                return 3;
            case "Thursday":
                return 4;
            case "Friday":
                return 5;
            case "Saturday":
                return 6;
            case "Sunday":
                return 7;
            default:
                return 0; // 0 表示错误
        }
    }

}

