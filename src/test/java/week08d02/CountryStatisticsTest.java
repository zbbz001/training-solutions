package week08d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountryStatisticsTest {

    @Test
    public void countryStatisticListLengthTest() {
        CountryStatistics statistics = new CountryStatistics();
        statistics.readCountries("countries.txt");

        assertEquals(11, statistics.getCountryList().size());
    }

    @Test
    public void countryStatisticShortestTest() {
        CountryStatistics statistics = new CountryStatistics();
        statistics.readCountries("countries.txt");

        assertEquals("Kongoi_Demokratikus_Koztarsasag", statistics.maxPopulation().getName());
    }

}