package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ToDoList {

    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void updateTask(int index, String title, String category, LocalDate deadline) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).updateTask(title, category, deadline);
        }
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }

    public void markTaskCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markCompleted();
        }
    }

    public List<Task> showTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return null;
        }
        else {
            return tasks;
        }



    }

    public List<Task> getTasks() {
        return tasks;
    }
}
