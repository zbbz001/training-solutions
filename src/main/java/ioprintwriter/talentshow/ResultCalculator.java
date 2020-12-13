package ioprintwriter.talentshow;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ResultCalculator {
    List<Production> productions = new ArrayList<>();
    List<Vote> votes = new ArrayList<>();

    public void readTalents(Path talentsFile) {
        try (BufferedReader reader = Files.newBufferedReader(talentsFile, Charset.defaultCharset())) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                productions.add(new Production(Integer.parseInt(parts[0]), parts[1]));
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("The file cannot read.");
        }
    }

    public void calculateVotes(Path votesFile) {
        intVotes();

        try (BufferedReader read = Files.newBufferedReader(votesFile, Charset.defaultCharset())) {
            String line;
            while ((line = read.readLine()) != null) {
                addVote(Integer.parseInt(line));
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("The file cannot read.");
        }
    }

    public void writeResultToFile(Path resultFile) {
        try (PrintWriter printWriter = new PrintWriter(Files.newBufferedWriter(resultFile, Charset.defaultCharset()))) {
            Vote maxVote = votes.get(0);
            for (Vote vote : votes) {
                if (vote.getNumber() > maxVote.getNumber()) {
                    maxVote = vote;
                }

                printWriter.print(vote.getId() + " ");
                printWriter.print(getProductionNameById(vote.getId()) + " ");
                printWriter.println(vote.getNumber());
            }

            printWriter.print("Winner: ");
            printWriter.println(getProductionNameById(maxVote.getId()));

        } catch (IOException ioe) {
            throw new IllegalStateException("The file cannot write");
        }
    }

    private String getProductionNameById(int id) {
        for (Production production : productions) {
            if (production.getId() == id) {
                return production.getName();
            }
        }

        return null;
    }

    private void intVotes() {
        for (Production production : productions) {
            votes.add(new Vote(production.getId(), 0));
        }
    }

    private void addVote(int productionId) {
        for (Vote vote : votes) {
            if (vote.getId() == productionId) {
                vote.incNum();
            }
        }
    }

    public List<Production> getProductions() {
        return productions;
    }

    public List<Vote> getVotes() {
        return votes;
    }
}
