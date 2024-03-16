package org.example.assignment01todo.Todo.Service;
import org.example.assignment01todo.Todo.Model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TaskService {

    private final List<Task> todoList;


    @Autowired
    public TaskService(List<Task> todoList) {
        this.todoList = todoList;
    }

    public void addTask(Task task) {
        todoList.add(task);
    }

}
