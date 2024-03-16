package org.example.assignment01todo.Todo.Service;
import org.example.assignment01todo.Todo.Model.Task;
import org.example.assignment01todo.Todo.Repository.ToDoListDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TaskService {

    private final List<Task> todoList;
    private final ToDoListDataSource toDoListDataSource;
    @Autowired
    public TaskService(List<Task> todoList, ToDoListDataSource toDoListDataSource) {
        this.todoList = todoList;
        this.toDoListDataSource = toDoListDataSource;
    }

    public void addTask(Task task) {
        todoList.add(task);
    }

    public List<Task> getAllTasks() {
        return toDoListDataSource.todoList();
    }

    public Task getTaskById(int id) {
        return toDoListDataSource.todoList().stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .orElse(null);
    }
    public void updateTask(Task task) {
        Task existingTask = getTaskById(task.getId());
        if (existingTask != null) {
            existingTask.setTaskName(task.getTaskName());
            existingTask.setDescription(task.getDescription());
            existingTask.setDone(task.isDone());
        }
    }

    public void deleteTask(int id) {
        todoList.removeIf(task -> task.getId() == id);
    }
}
