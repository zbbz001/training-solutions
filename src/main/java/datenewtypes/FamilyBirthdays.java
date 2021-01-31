package datenewtypes;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.List;

public class FamilyBirthdays {

    private List<LocalDate> birthdays;

    public FamilyBirthdays(LocalDate... birthdays) {
        this.birthdays = Arrays.asList(birthdays);
    }

    public boolean isFamilyBirthday(TemporalAccessor date) {
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        int day = date.get(ChronoField.DAY_OF_MONTH);

        return birthdays.stream().anyMatch(birthday -> birthday.getDayOfMonth() == day && birthday.getMonthValue() == month);
    }

    public int nextFamilyBirthDay(TemporalAccessor date) {
        int actualYear = date.get(ChronoField.YEAR);
        LocalDate actualDate = LocalDate.of(actualYear, date.get(ChronoField.MONTH_OF_YEAR), date.get(ChronoField.DAY_OF_MONTH));
        int min = Integer.MAX_VALUE;

        for (LocalDate birthday : birthdays) {
            LocalDate nextBirthday = birthday.withYear(actualYear);

            if (nextBirthday.isBefore(actualDate)) {
                nextBirthday = birthday.withYear(actualYear + 1);
            }

            int diff = (int) ChronoUnit.DAYS.between(actualDate, nextBirthday);
            System.out.println(diff);
            if (diff <= min) {
                min = diff;
            }
        }

        return min;
    }
}
