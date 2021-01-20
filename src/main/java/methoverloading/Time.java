package methoverloading;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public Time(int hours) {
        this.hours = hours;
    }

    public Time(Time time) {
        this.hours = time.hours;
        this.minutes = time.minutes;
        this.seconds = time.seconds;
    }

    public boolean isEqual(Time time) {
        return timeInSeconds() == time.timeInSeconds();
    }

    public boolean isEqual(int hours, int minutes, int seconds) {
        return timeInSeconds() == new Time(hours, minutes, seconds).timeInSeconds();
    }

    public boolean isEarlier(Time time) {
        return timeInSeconds() < time.timeInSeconds();
    }

    public boolean isEarlier(int hours, int minutes, int seconds) {
        return timeInSeconds() < new Time(hours, minutes, seconds).timeInSeconds();
    }

    private int timeInSeconds() {
        return hours * 3600 + minutes * 60 + seconds;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
}
