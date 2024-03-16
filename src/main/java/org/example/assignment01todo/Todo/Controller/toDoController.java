package org.example.assignment01todo.Todo.Controller;
import org.example.assignment01todo.Todo.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.example.assignment01todo.Todo.Model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Todo")
public class toDoController {
    private final List<Task> tasks;

    public toDoController() {
        tasks = new ArrayList<>();

        // Adding sample tasks for demonstration
        tasks.add(new Task(1, "Work Out", "This weekend", false, LocalDate.now() ));
        tasks.add(new Task(2, "Study", "For exams", false, LocalDate.now()));
        tasks.add(new Task(3, "Grocery shopping", "Buy vegetables", false, LocalDate.now()));
    }

    @GetMapping
    public String homePage(Model model) {
        model.addAttribute("tasks", tasks);
        return "Todo/HomePage";
    }

    @GetMapping("/new")
    public String newTask(Model model) {
        model.addAttribute("task", new Task());
        return "Todo/new";
    }

    @PostMapping("new")
    public String addTask(@ModelAttribute Task task) {
        task.setDate(LocalDate.now());
        tasks.add(task);
        return "redirect:/Todo";
    }

    @PostMapping("/{id}/done")
    public String markTaskAsDone(@PathVariable int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setDone(true);
                break;
            }
        }
        return "redirect:/Todo";
    }

}