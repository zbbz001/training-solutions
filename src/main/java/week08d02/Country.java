package week08d02;

public class Country {
    private String name;
    private int population;
    private int numberOfFlagColors;
    private int numberOfNeighbor;

    public Country(String name, int population, int numberOfFlagColors, int numberOfNeighbor) {
        this.name = name;
        this.population = population;
        this.numberOfFlagColors = numberOfFlagColors;
        this.numberOfNeighbor = numberOfNeighbor;
    }

    public Country(String string) {
        String[] parts = string.split(" ");

        if (parts.length != 4) {
            throw new IllegalArgumentException("Wrong data structure, country data:" + string);
        }

        name = parts[0];
        population = Integer.parseInt(parts[1]);
        numberOfFlagColors = Integer.parseInt(parts[2]);
        numberOfNeighbor = Integer.parseInt(parts[3]);
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getNumberOfFlagColors() {
        return numberOfFlagColors;
    }

    public int getNumberOfNeighbor() {
        return numberOfNeighbor;
    }
}
