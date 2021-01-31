package datenewtypes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DateOfBirth {

    private LocalDate dateOfBirth;


    public DateOfBirth(String date, String pattern, Locale locale) {
        if (pattern == null || pattern.isEmpty()) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: ");
        }

        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }

        dateOfBirth = LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern, locale));
    }

    public DateOfBirth(String date, String pattern) {
        new DateOfBirth(date, pattern, Locale.getDefault());
    }

    public DateOfBirth(int year, int month, int day) {
        this.dateOfBirth = LocalDate.of(year, month, day);
    }

    public String findDayOfWeekForBirthDate(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }

        return dateOfBirth.format(DateTimeFormatter.ofPattern("EEEE", locale));
    }

    public String findDayOfWeekForBirthDate(Locale locale, LocalDate other) {
        return other.format(DateTimeFormatter.ofPattern("EEEE", locale));
    }

    public int countDaysSinceBirth(LocalDate now) {
        if (dateOfBirth.isAfter(now)) {
            throw new IllegalStateException("Birthdate is in the future!");
        }

        return (int) ChronoUnit.DAYS.between(dateOfBirth, now);
    }

    public int countDaysBetween(DateOfBirth other) {
        return countDaysSinceBirth(other.getDateOfBirth());
    }

    public String toString(String pattern) {
        if (pattern == null || pattern.isEmpty()) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: ");
        }

        return dateOfBirth.format(DateTimeFormatter.ofPattern(pattern));
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}
