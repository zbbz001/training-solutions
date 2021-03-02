package exam03retake02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TodoList {
    private List<Todo> todos = new ArrayList<>();

    public long getNumberOfItemsLeft() {
        return todos.stream()
                .filter(todo -> todo.getState().equals(State.NON_COMPLETED))
                .count();
    }


    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    public List<Todo> getTodos() {
        return new ArrayList<>(todos);
    }

    public List<String> getMostImportantTodosText() {
        Optional<Todo> result = todos.stream().min(Comparator.comparing(Todo::getPriority));

        if (result.isPresent()) {
            Todo minPriority = result.get();

            return todos.stream()
                    .filter(todo -> todo.getPriority() == minPriority.getPriority())
                    .map(Todo::getText)
                    .collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    public void deleteCompleted() {
        todos = todos.stream()
                .filter(todo -> todo.getState().equals(State.NON_COMPLETED))
                .collect(Collectors.toList());
    }
}
