package math;

import java.util.Random;

public class RoundingAnomaly {

    public static void main(String[] args) {
        RoundingAnomaly roundingAnomaly = new RoundingAnomaly();

        double sum = 0;

        for (int i = 0; i < 100; i++) {
            double diff = roundingAnomaly.difference(1000, 1_000_000, 5);
            sum += diff;
            System.out.println("Diff: " + diff);
        }

        System.out.println(sum / 100);
    }

    public double[] randomNumbers(int size, double max, int scale) {
        double[] randomNumbers = new double[size];

        Random rnd = new Random();
        double factor = Math.pow(10, scale);

        for (int i = 0; i < size; i++) {
            randomNumbers[i] = Math.round(rnd.nextDouble() * max * factor) / factor;
        }

        return randomNumbers;
    }

    public double roundAfterSum(double[] numbers) {
        double sum = 0;
        for(double num:numbers) {
            sum += num;
        }

        return Math.round(sum);
    }

    public double sumAfterRound(double[] numbers) {
        double sum = 0;
        for(double num:numbers) {
            sum += Math.round(num);
        }

        return sum;
    }

    public double difference(int size, double max, int scale) {
        double[] numbers = randomNumbers(size, max, scale);
        double resultAfterSum = roundAfterSum(numbers);
        double resultAfterRound = sumAfterRound(numbers);

        return Math.abs(resultAfterSum - resultAfterRound);
    }
}
