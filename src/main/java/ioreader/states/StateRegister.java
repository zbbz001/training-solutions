package ioreader.states;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StateRegister {

    List<State> states = new ArrayList<>();

    public void readStatesFromFile(String stringFileName) {
        Path file = Path.of("src/main/resources/" + stringFileName);

        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("-");
                states.add(new State(parts[0], parts[1]));
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    public String findCapitalByStateName(String stateName) {
        for (State state : states) {
            if (state.getStateName().equals(stateName)) {
                return state.getCapital();
            }
        }

        throw new IllegalArgumentException("No state with this name!");
    }


    public List<State> getStates() {
        return new ArrayList<>(states);
    }
}
