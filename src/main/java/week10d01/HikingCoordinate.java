package week10d01;

public class HikingCoordinate {
    private double longitude;
    private double latitude;
    private double elevation;

    public HikingCoordinate(String logLine) {
        String[] parts = logLine.split(", ");

        longitude = Double.parseDouble(parts[0]);
        longitude = Double.parseDouble(parts[1]);
        elevation = Double.parseDouble(parts[2]);
    }

    public double getElevation() {
        return elevation;
    }
}
