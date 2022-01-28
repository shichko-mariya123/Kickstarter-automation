package utilities;

import com.joestelmach.natty.DateGroup;
import com.joestelmach.natty.Parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DateUtil {

    public static Date parseToDate(String str) throws ParseException {
        Parser parser = new Parser();
        List<DateGroup> groups = parser.parse(str);
        for (DateGroup group : groups) {
            List<Date> dates = group.getDates();
            if (dates.size() > 0) {
                return dates.get(0);
            }
        }
        throw new IllegalArgumentException("Could not natural language date: " + str);
    }

    public static int getNumberOfDaysToPresentDate(Date date) throws ParseException {
        String presentDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss z YYYY").format(new Date());
        long difference = date.getTime() - parseToDate(presentDate).getTime();
        return (int) difference / (24 * 60 * 60 * 1000);
    }
}
