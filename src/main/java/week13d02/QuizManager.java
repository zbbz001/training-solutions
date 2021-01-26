package week13d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class QuizManager {
    private Quiz quiz = new Quiz();
    private Map<String, Quiz> quizAnswers = new HashMap<>();

    public static void main(String[] args) {
        QuizManager qm = new QuizManager();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(QuizManager.class.getResourceAsStream("/results.txt")))) {
            qm.read(reader);

            System.out.println(qm.isTrueAnswer("AH2", 1));
            System.out.println(qm.getMostSkipper());
            System.out.println(qm.getWinner());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read(BufferedReader reader) throws IOException {
        readQuizTrueAnswers(reader.readLine());
        String line;
        while ((line = reader.readLine()) != null) {
            readQuizAnswer(line);
        }
    }

    private void readQuizAnswer(String line) {
        String[] parts = line.split(" ");
        if (!quizAnswers.containsKey(parts[0])) {
            quizAnswers.put(parts[0], new Quiz());
        }
        quizAnswers.get(parts[0]).addToQuiz(parts[1]);
    }

    private void readQuizTrueAnswers(String line) {
        String[] parts = line.split("");
        for (String part : parts) {
            quiz.addToQuiz(part);
        }
    }

    public boolean isTrueAnswer(String id, int quizNumber) {
        String trueAnswer = quiz.getAnswer(quizNumber);
        String quizResult = quizAnswers.get(id).getAnswer(quizNumber);

        return quizResult.equals(trueAnswer);
    }

    public String getMostSkipper() {
        String mostSkipper = null;
        int max = 0;
        for (Map.Entry<String, Quiz> entry : quizAnswers.entrySet()) {
            if (entry.getValue().skippedAnswers() > max) {
                mostSkipper = entry.getKey();
                max = entry.getValue().skippedAnswers();
            }
        }

        return mostSkipper;
    }

    public String getWinner() {
        String winner = null;
        int max = 0;
        for (Map.Entry<String, Quiz> entry : quizAnswers.entrySet()) {
            if (entry.getValue().getPoints(quiz) > max) {
                winner = entry.getKey();
                max = entry.getValue().getPoints(quiz);
            }
        }

        return winner;
    }
}
