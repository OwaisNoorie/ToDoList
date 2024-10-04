package com.todoapp;

import java.time.LocalDate;

public class Task {
    private int id;
    private String description;
    private String priority; // e.g., High, Medium, Low
    private LocalDate dueDate;
    private boolean isCompleted;

    // Constructor
    public Task(int id, String description, String priority, LocalDate dueDate) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
        this.isCompleted = false; // Default to not completed
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    // ... (other getters and setters)

    @Override
    public String toString() {
        return "Task ID: " + id +
                "\nDescription: " + description +
                "\nPriority: " + priority +
                "\nDue Date: " + dueDate +
                "\nStatus: " + (isCompleted ? "Completed" : "Pending") + "\n";
    }
}
