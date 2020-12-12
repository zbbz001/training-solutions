package exceptions.polinom;

public class Polynomial {
    private double[] coefficients;

    public Polynomial(double[] coefficients) {
        if (coefficients == null) {
            throw new NullPointerException("coefficients is null");
        }

        this.coefficients = coefficients;
    }

    public Polynomial(String[] coefficientsString) {
        if (coefficientsString == null) {
            throw new NullPointerException("coefficientStrs is null");
        }

        try {
            coefficients = new double[coefficientsString.length];

            for (int i = 0; i < coefficientsString.length; i++) {
                coefficients[i] = Double.parseDouble(coefficientsString[i]);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Illegal coefficients, not a number", e);
        }
    }

    public double evaluate(double x) {
        double sum = 0;
        int n = coefficients.length - 1;
        for (int i = n; i >= 0; i--) {
            sum += coefficients[i] * Math.pow(x, (double) n - i);
        }

        return sum;
    }

    public double[] getCoefficients() {
        return coefficients;
    }
}
