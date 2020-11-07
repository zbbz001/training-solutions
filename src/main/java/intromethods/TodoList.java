package intromethods;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private List<Todo> todos = new ArrayList<>();

    public void addTodo(String caption) {
        todos.add(new Todo(caption));
    }

    public void finishTodos(String caption) {
        for(Todo todo:todos) {
            if(todo.getCaption().equals(caption) && !todo.isFinished()) {
                todo.finish();
            }
        }
    }

    public void finishAllTodos(List<String> todosToFinish) {
        for(String caption:todosToFinish) {
            finishTodos(caption);
        }
    }

    public List<String> todosToFinish(){
        List<String> todosToFinish = new ArrayList<>();

        for(Todo todo:todos) {
            if(!todo.isFinished()) {
                todosToFinish.add(todo.getCaption());
            }
        }

        return todosToFinish;
    }

    public int numberOfFinishedTodos() {
        int sum = 0;

        for(Todo todo:todos) {
            if(todo.isFinished()) {
                sum++;
            }
        }

        return sum;
    }

    @Override
    public String toString() {
        return todos.toString();
    }
}
