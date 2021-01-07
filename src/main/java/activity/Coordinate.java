package activity;

public class Coordinate {
    private double latitude;
    private double longitude;

    public Coordinate(double latitude, double longitude) {
        if (isValidCoordinate(latitude, -90, 90) && isValidCoordinate(longitude, -180, 180)) {
            this.latitude = latitude;
            this.longitude = longitude;
        } else {
            throw new IllegalArgumentException("The coordinate is not valid!");
        }
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    private boolean isValidCoordinate(double value, double min, double max) {
        return value >= min && value <= max;
    }
}
