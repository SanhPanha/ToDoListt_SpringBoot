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
        tasks.add(new Task(1, "Work Out", "This weekend", true, LocalDate.now() ));
        tasks.add(new Task(2, "Study", "For exams", true, LocalDate.now()));
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

    @GetMapping("/edit/{id}")
    public String editTask(@PathVariable int id, Model model) {
        // Find the task in the list
        for (Task task : tasks) {
            if (task.getId() == id) {
                // Add the task to the model
                model.addAttribute("task", task);
                break;
            }
        }
        // Return the name of the view that contains the form for editing a task
        return "Todo/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateTask(@ModelAttribute Task task) {
        // Find the task in the list
        for (Task existingTask : tasks) {
            if (existingTask.getId() == task.getId()) {
                // Update the task fields
                existingTask.setTaskName(task.getTaskName());
                existingTask.setDescription(task.getDescription());
                existingTask.setDone(task.isDone());
                break;
            }
        }
        // Redirect to the home page
        return "redirect:/Todo";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable int id) {
        tasks.removeIf(task -> task.getId() == id);
        return "redirect:/Todo";
    }

    @GetMapping("/search")
    public String searchTasks(@RequestParam String status, Model model) {
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : tasks) {
            if ((status.equals("done") && task.isDone()) || (status.equals("not done") && !task.isDone())) {
                filteredTasks.add(task);
            }
        }
        model.addAttribute("tasks", filteredTasks);
        return "Todo/search";
    }

}