package week13d02;

import java.util.*;

public class Quiz {
    private List<String> answers = new ArrayList<>();

    public void addToQuiz(String result) {
        answers.add(result);
    }

    public String getAnswer(int i) {
        return answers.get(i - 1);
    }

    public int skippedAnswers() {
        return Collections.frequency(answers, "X");
    }

    public int getPoints(Quiz trueAnswer) {
        int sum = 0;

        for (int i = 1; i < answers.size() + 1; i++) {
            if (trueAnswer.getAnswer(i).equals(answers.get(i - 1))) {
                sum += i;
            }
        }

        return sum;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "answers=" + answers +
                '}';
    }
}
