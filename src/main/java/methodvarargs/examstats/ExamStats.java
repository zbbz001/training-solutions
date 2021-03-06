package methodvarargs.examstats;


public class ExamStats {
    private int maxPoints;

    public ExamStats(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public int getNumberOfTopGrades(int limitInPercent, int... results) {
        if (results == null || results.length == 0) {
            throw new IllegalArgumentException("Number of results must not be empty!");
        }

        int counter = 0;

        for (int result : results) {
            if (result >= maxPoints * limitInPercent / 100) {
                counter++;
            }
        }

        return counter;
    }

    public boolean hasAnyFailed(int limitInPercent, int... results) {
        return getNumberOfTopGrades(limitInPercent, results) != results.length;
    }
}
