package activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Track {
    private List<TrackPoint> trackPoints = new ArrayList<>();

    public void addTrackPoint(TrackPoint trackPoint) {
        trackPoints.add(trackPoint);
    }

    public Coordinate findMaximumCoordinate() {
        double maxLongitude = trackPoints.get(0).getCoordinate().getLongitude();
        double maxLatitude = trackPoints.get(0).getCoordinate().getLatitude();

        for (TrackPoint trackPoint : trackPoints) {
            if (trackPoint.getCoordinate().getLongitude() > maxLongitude) {
                maxLongitude = trackPoint.getCoordinate().getLongitude();
            }
            if (trackPoint.getCoordinate().getLatitude() > maxLatitude) {
                maxLatitude = trackPoint.getCoordinate().getLatitude();
            }
        }

        return new Coordinate(maxLatitude, maxLongitude);
    }

    public Coordinate findMinimumCoordinate() {
        double minLongitude = trackPoints.get(0).getCoordinate().getLongitude();
        double minLatitude = trackPoints.get(0).getCoordinate().getLatitude();

        for (TrackPoint trackPoint : trackPoints) {
            if (trackPoint.getCoordinate().getLongitude() < minLongitude) {
                minLongitude = trackPoint.getCoordinate().getLongitude();
            }
            if (trackPoint.getCoordinate().getLatitude() < minLatitude) {
                minLatitude = trackPoint.getCoordinate().getLatitude();
            }
        }

        return new Coordinate(minLatitude, minLongitude);
    }

    public double getDistance() {
        double distance = 0;
        TrackPoint previous = null;

        for (TrackPoint actual : trackPoints) {
            if (previous != null) {
                distance += actual.getDistanceFrom(previous);
            }

            previous = actual;
        }

        return distance;
    }

    public double getFullDecrease() {
        double fullDecrease = 0;
        TrackPoint previous = null;

        for (TrackPoint actual : trackPoints) {
            if (previous != null && actual.getElevation() < previous.getElevation()) {
                fullDecrease += previous.getElevation() - actual.getElevation();
            }

            previous = actual;
        }

        return fullDecrease;
    }

    public double getFullElevation() {
        double fullElevation = 0;
        TrackPoint previous = null;

        for (TrackPoint actual : trackPoints) {
            if (previous != null && actual.getElevation() > previous.getElevation()) {
                fullElevation += actual.getElevation() - previous.getElevation();
            }

            previous = actual;
        }

        return fullElevation;
    }

    public double getRectangleArea() {
        Coordinate maxCoordinate = findMaximumCoordinate();
        Coordinate minCoordinate = findMinimumCoordinate();

        return (maxCoordinate.getLatitude() - minCoordinate.getLatitude()) * (maxCoordinate.getLongitude() - minCoordinate.getLongitude());
    }

    public void loadFromGpx(InputStream inputStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            Coordinate coordinate = null;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("<trkpt")) {
                    coordinate = logParseCoordinate(line);
                }
                if (line.startsWith("<ele") && coordinate != null) {
                    trackPoints.add(new TrackPoint(coordinate, logParseElevation(line)));
                    coordinate = null;
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    private Coordinate logParseCoordinate(String line) {
        int latStart = line.indexOf("lat=\"") + "lat=\"".length();
        int longStart = line.indexOf("lon=\"") + "lon=\"".length();

        double latitude = Double.parseDouble(line.substring(latStart, latStart + 10));
        double longitude = Double.parseDouble(line.substring(longStart, longStart + 10));

        return new Coordinate(latitude, longitude);
    }

    private double logParseElevation(String line) {
        int elevationStart = "<ele>".length();

        return Double.parseDouble(line.substring(elevationStart, elevationStart + 5));
    }

    //<ele>134.2</ele>
    public List<TrackPoint> getTrackPoints() {
        return new ArrayList<>(trackPoints);
    }
}
