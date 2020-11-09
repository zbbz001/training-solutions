package enumtype.week;

import java.util.ArrayList;
import java.util.List;

public class WorkdayCalculator {

    public List<DayType> dayTypes(Day firstDay, int numberOfDays) {
        List<DayType> dayTypeList = new ArrayList<>();
        Day day = firstDay;

        for (int i = 0; i < numberOfDays; i++) {
            dayTypeList.add(day.getDayType());
            day = nextDay(day);
        }

        return dayTypeList;
    }

    private Day nextDay(Day day) {
        if (day.ordinal() == Day.values().length - 1) {
            return Day.values()[0];
        }

        return Day.values()[day.ordinal() + 1];
    }
}
