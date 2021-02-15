package week16d01;

import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class CanoeRental implements Cloneable, Comparable<CanoeRental> {
    private String name;
    private CanoeType canoeType;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public CanoeRental() {
    }

    public CanoeRental(CanoeRental canoeRental) {
        name = canoeRental.name;
        canoeType = canoeRental.canoeType;
        startTime = canoeRental.startTime;
        endTime = canoeRental.endTime;
    }

    public CanoeRental(String name, CanoeType canoeType, String dateTimeString) {
        this.name = name;
        this.canoeType = canoeType;
        this.startTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public void setEndTime(LocalDateTime endTime) {
        if (endTime.isBefore(startTime)) {
            throw new IllegalArgumentException("end time must be after than start time");
        }

        this.endTime = endTime;
    }

    public double calculateRentalSum() {
        double rentHours = Duration.between(startTime, endTime)
                .get(ChronoUnit.HOURS);

        return canoeType.getRate() * rentHours;
    }

    public String getName() {
        return name;
    }

    public CanoeType getCanoeType() {
        return canoeType;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    @Override
    public int compareTo(@NotNull CanoeRental o) {
        return startTime.compareTo(o.startTime);
    }

}
