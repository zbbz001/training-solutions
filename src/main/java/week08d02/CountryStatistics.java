package week08d02;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {
    private List<Country> countryList = new ArrayList<>();

    public void readCountries(String filename) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                countryList.add(new Country(line));
            }
        } catch (IOException e) {
            throw new IllegalStateException("File not found, filename:" + filename);
        }
    }

    public Country maxPopulation() {
        Country max = countryList.get(0);
        for (Country country : countryList) {
            if (country.getPopulation() > max.getPopulation()) {
                max = country;
            }
        }
        return max;
    }

    public List<Country> getCountryList() {
        return countryList;
    }
}
