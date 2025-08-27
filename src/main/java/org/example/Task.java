package org.example;

import java.time.LocalDate;

public class Task {
    private String title;
    private String category;
    private LocalDate deadline;
    private boolean completed;

    public Task(String title, String category, LocalDate deadline) {
        this.title = title;
        this.category = category;
        this.deadline = deadline;
        this.completed = false;
    }

    public void markCompleted() {
        this.completed = true;
    }

    public void updateTask(String title, String category, LocalDate deadline) {
        this.title = title;
        this.category = category;
        this.deadline = deadline;
    }

    public String toString() {
        return "[ " + (completed ? "X" : " ") + " ] " + title +
                " | Category: " + category +
                " | Deadline: " + deadline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
