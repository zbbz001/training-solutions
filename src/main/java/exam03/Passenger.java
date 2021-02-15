package exam03;

import org.jetbrains.annotations.NotNull;

public class Passenger {
    private String name;
    private CruiseClass cruiseClass;

    public Passenger() {
    }

    public Passenger(String name, CruiseClass cruiseClass) {
        this.name = name;
        this.cruiseClass = cruiseClass;
    }

    public String getName() {
        return name;
    }

    public CruiseClass getCruiseClass() {
        return cruiseClass;
    }
}
