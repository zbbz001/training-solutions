package methodoverloading.pub;

import methodoverloading.Time;

public class Pub {
    private String name;
    private int hours;
    private int minutes;

    public Time getOpenFrom() {
        return new Time(hours, minutes);
    }

    public String getName() {
        return name;
    }

    public Pub(String name, int hours, int minutes) {
        this.name = name;
        this.hours = hours;
        this.minutes = minutes;
    }

    @Override
    public String toString() {
        return name + ";" + hours + ":" + minutes;
    }
}
