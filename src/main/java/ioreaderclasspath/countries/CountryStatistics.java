package ioreaderclasspath.countries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {
    private List<Country> countryList = new ArrayList<>();

    public void readFromFile(String path) {
        Path file = Path.of(path);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(CountryStatistics.class.getResourceAsStream(path)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                countryList.add(new Country(parts[0], Integer.parseInt(parts[1])));
            }
        } catch (IOException e) {
            throw new IllegalStateException("The file cannot read.");
        }
    }

    public int numberOFCountries() {
        return countryList.size();
    }

    public Country mostBorderCountries() {
        Country maxBorder = countryList.get(0);

        for (Country country : countryList) {
            if (country.getBorderCountries() > maxBorder.getBorderCountries()) {
                maxBorder = country;
            }
        }

        return maxBorder;
    }

    public List<Country> getCountryList() {
        return new ArrayList<>(countryList);
    }
}
