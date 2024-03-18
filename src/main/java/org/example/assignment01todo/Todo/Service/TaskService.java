package org.example.assignment01todo.Todo.Service;
import org.example.assignment01todo.Todo.Model.Task;
import org.example.assignment01todo.Todo.Repository.ToDoListDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TaskService {
    @Autowired
    public TaskService(List<Task> todoList, ToDoListDataSource toDoListDataSource) {
    }
}

