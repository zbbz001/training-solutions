package week06.d01;

import java.util.ArrayList;
import java.util.List;

public class SortedNumbers {
    private List<Double> positives = new ArrayList<>();
    private List<Double> negatives = new ArrayList<>();
    private List<Double> zeros = new ArrayList<>();

    public void sortNumber(double number) {
        if (number > 0) {
            addToPositives(number);
        } else if (number < 0) {
            addToNegatives(number);
        } else {
            addToZeros(number);
        }
    }

    public double sumPositives() {
        double sum = 0;

        for (double n : positives) {
            sum += n;
        }

        return sum;
    }

    public double sumNegatives() {
        double sum = 0;

        for (double n : negatives) {
            sum += n;
        }

        return sum;
    }

    public void addToPositives(double number) {
        positives.add(number);
    }

    public void addToNegatives(double number) {
        negatives.add(number);
    }

    public void addToZeros(double number) {
        zeros.add(number);
    }

    public List<Double> getZeros() {
        return zeros;
    }

    @Override
    public String toString() {
        return "sum of positive numbers: " + sumPositives() + ", sum of negative numbers: " + sumNegatives() +
                " number of zeros: " + getZeros().size();
    }
}
