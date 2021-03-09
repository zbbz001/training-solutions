package datenewtypes;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DailyRoutine {
    private LocalTime startTime;

    public DailyRoutine(int hour, int min) {
        startTime = LocalTime.of(hour, min);
    }

    public DailyRoutine(String timeString) {
        startTime = LocalTime.parse(timeString, DateTimeFormatter.ofPattern("HH:mm"));
    }

    public void setFutureTime(int minutes) {
        startTime = startTime.plusMinutes(minutes);
    }

    public boolean isBeforeNoon() {
        return startTime.isBefore(LocalTime.NOON);
    }
}
