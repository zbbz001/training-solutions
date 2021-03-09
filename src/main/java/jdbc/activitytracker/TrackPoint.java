package jdbc.activitytracker;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TrackPoint {
    private long id;
    private LocalDateTime time;
    private double lat;
    private double lon;

    public TrackPoint(LocalDateTime time, double lat, double lon) {
        this.time = time;
        this.lat = lat;
        this.lon = lon;
    }

    public TrackPoint(long id, LocalDateTime time, double lat, double lon) {
        this.id = id;
        this.time = time;
        this.lat = lat;
        this.lon = lon;
    }

    public boolean isValid() {
        return lat <= 90 && lat >= -90 && lon <= 180 && lon >= -180;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}
