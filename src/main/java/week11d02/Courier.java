package week11d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Courier {
    private TreeSet<Ride> rides = new TreeSet<>();

    public void readLog(InputStream inputStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                rides.add(new Ride(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot the file", e);
        }
    }

    public Ride getFirstRide() {
        return rides.first();
    }

    public List<Integer> getHolidays() {
        List<Integer> days = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        Iterator<Ride> value = rides.iterator();

        while (value.hasNext()) {
            Ride ride = value.next();
            if (days.contains(ride.getDay())) {
                days.remove(Integer.valueOf(ride.getDay()));
            }
        }

        return days;
    }

    public int[] dailyDistances() {
        int[] distances = new int[7];

        for (Ride ride : rides) {
            distances[ride.getDay() - 1] += ride.getDistance();
        }

        return distances;
    }

    public TreeSet<Ride> getRides() {
        return new TreeSet<>(rides);
    }
}
