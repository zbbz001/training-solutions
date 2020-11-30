package methodparam.measuring;

public class Measurement {
    private double[] measurementResult;

    public Measurement(double[] measurementResult) {
        this.measurementResult = measurementResult;
    }

    public int findFirstIndexInLimit(int lower, int upper) {
        for (int i = 0; i < measurementResult.length; i++) {
            if (measurementResult[i] > lower && measurementResult[i] < upper) {
                return i;
            }
        }

        return -1;
    }

    public double minimum() {
        double min = measurementResult[0];

        for (double result : measurementResult) {
            if (result < min) {
                min = result;
            }
        }

        return min;
    }

    public double maximum() {
        double max = measurementResult[0];

        for (double result : measurementResult) {
            if (result > max) {
                max = result;
            }
        }

        return max;
    }

    public ExtremValues minmax() {
        return new ExtremValues(minimum(), maximum());
    }
}
