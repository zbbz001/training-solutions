package interfaces.simplethread;

import java.util.ArrayList;
import java.util.List;

public class SimpleThread implements Runnable {
    private List<String> tasks;

    public SimpleThread(List<String> tasks) {
        this.tasks = tasks;
    }

    private boolean nextStep() {
        if(!tasks.isEmpty()) {
            tasks.remove(tasks.size() - 1);
        }

        return !tasks.isEmpty();
    }

    @Override
    public void run() {
        while(nextStep()) {

        }
    }

    public List<String> getTasks() {
        return tasks;
    }
}
