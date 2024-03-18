package org.example.assignment01todo.Todo.Repository;

import org.example.assignment01todo.Todo.Model.Task;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class ToDoListDataSource {
    @Bean
    public List<Task> todoList() {
        return new ArrayList<>();
    }
}
