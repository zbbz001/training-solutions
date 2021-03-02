package exam03retake02;

public class Todo {

    private final String text;
    private State state;
    private final int priority;

    private static final int PRIORITY_MIN = 1;
    private static final int PRIORITY_MAX = 5;

    public Todo(String text, int priority) {
        if (!isPriority(priority)) {
            throw new IllegalArgumentException("Invalid priority: " + priority);
        }

        this.text = text;
        this.priority = priority;
        this.state = State.NON_COMPLETED;
    }

    public void complete() {
        state = state.next();
    }

    private boolean isPriority(int priority) {
        return priority >= PRIORITY_MIN && priority <= PRIORITY_MAX;
    }

    public State getState() {
        return state;
    }

    public int getPriority() {
        return priority;
    }

    public String getText() {
        return text;
    }

}
