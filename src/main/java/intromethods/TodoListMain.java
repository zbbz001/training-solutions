package intromethods;

import java.util.Arrays;

public class TodoListMain {

    public static void main(String[] args) {

        TodoList todoList = new TodoList();

        todoList.addTodo("Learn something new");
        todoList.addTodo("Figure out what you're good at and work on getting even better");
        todoList.addTodo("Visit your nearest library");
        todoList.addTodo("Listen to some music for productivity to get you focused and in the zone");
        todoList.addTodo("Learn how to invest your money.");

        System.out.println(todoList);

        todoList.finishTodos("Visit your nearest library");
        System.out.println(todoList);

        todoList.finishAllTodos(Arrays.asList("Learn how to invest your money.", "Listen to some music for productivity to get you focused and in the zone"));
        System.out.println(todoList);

        System.out.println(todoList.todosToFinish());

        System.out.println(todoList.numberOfFinishedTodos());

        System.out.println();

        System.out.println(todoList.toString());
    }
}
