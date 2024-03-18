package org.example.assignment01todo.Todo.Model;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task {
    // Getters and setters
    @Setter
    @Getter
    private int id;
    @Getter
    @Setter
    private String taskName;
    @Getter
    @Setter
    private String description;
    private boolean isDone;
    @Getter
    @Setter
    private LocalDate date;

    // Constructors
    public Task() {
    }

    public Task(int id, String taskName, String description, boolean isDone, LocalDate date) {
        this.id = id;
        this.taskName = taskName;
        this.description = description;
        this.isDone = isDone;
        this.date = date;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    public String getFormattedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return date.format(formatter);
    }
}


