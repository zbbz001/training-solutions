package dateperiod;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PensionCalculator {

    private static final int DAYS_IN_MONTH = 30;
    private static final int DAYS_IN_YEAR = 365;
    List<Period> employment = new ArrayList<>();

    public void addEmploymentPeriod(Period period) {
        employment.add(period);
    }

    public Period sumEmploymentPeriods() {
        Optional<Period> sumPeriod = employment.stream().reduce(Period::plus);

        if (sumPeriod.isPresent()) {
            return fullyNormalized(sumPeriod.get());
        }

        return Period.ZERO;
    }

    public Period modifyByDays(Period period, int i) {
        return period.plusDays(i);
    }

    public int calculateTotalDays(Period period) {
        return period.getYears() * DAYS_IN_YEAR + period.getMonths() * DAYS_IN_MONTH + period.getDays();
    }

    private Period fullyNormalized(Period period) {
        if (period.getDays() < DAYS_IN_MONTH) {
            return period.normalized();
        }

        return Period.of(period.getYears(), period.getMonths() + period.getDays() / DAYS_IN_MONTH, period.getDays() % DAYS_IN_MONTH);
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }

    public Period getPeriodBetweenDates(LocalDate fromDate, LocalDate toDate) {
        if (fromDate == null || toDate == null) {
            throw new NullPointerException("Null parameters are not allowed!");
        }

        return Period.between(fromDate, toDate);
    }


    public Period getPeriodBetweenDates(String fromDate, String toDate, String pattern) {
        if (isEmpty(fromDate)) {
            throw new IllegalArgumentException("Empty from date string, cannot use: ");
        }

        if (isEmpty(toDate)) {
            throw new IllegalArgumentException("Empty to date string, cannot use: ");
        }

        if (isEmpty(pattern)) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: ");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return Period.between(LocalDate.parse(fromDate, formatter), LocalDate.parse(toDate, formatter));
    }
}
