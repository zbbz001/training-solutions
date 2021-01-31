package datenewtypes;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class Rendezvous {

    private LocalTime time;

    public Rendezvous(String strTime, String pattern) {
        if (pattern == null || pattern.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string!");
        }

        if (strTime == null || strTime.isBlank()) {
            throw new IllegalArgumentException("Illegal time string: ");
        }

        try {
            time = LocalTime.parse(strTime, DateTimeFormatter.ofPattern(pattern));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Illegal time string: " + strTime);
        }
    }

    public Rendezvous(int hour, int minute) {
        time = LocalTime.of(hour, minute);
    }

    public int countMinutesLeft(LocalTime deadline) {
        if (time.isBefore(deadline)) {
            throw new MissedOpportunityException("Too late!");
        }

        return (int) ChronoUnit.MINUTES.between(deadline, time);
    }

    public void pushLater(int hour, int minute) {
        time = time.plusHours(hour).plusMinutes(minute);
    }

    public void pullEarlier(int hour, int minute) {
        time = time.minusHours(hour).minusMinutes(minute);
    }

    public String toString(String pattern) {
        if (pattern == null || pattern.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string!");
        }

        return time.format(DateTimeFormatter.ofPattern(pattern));
    }
}
