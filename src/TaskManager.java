package com.todoapp;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskManager {
    private List<Task> tasks;
    private int nextId;
    private static final String FILE_NAME = "tasks.json";
    private Gson gson;

    public TaskManager() {
        gson = new Gson();
        tasks = new ArrayList<>();
        loadTasks();
        nextId = getNextId();
    }

    // Add, View, Update, Delete methods as before

    // Save tasks to JSON file
    private void saveTasks() {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(tasks, writer);
        } catch (IOException e) {
            System.out.println("An error occurred while saving tasks.");
            e.printStackTrace();
        }
    }

    // Load tasks from JSON file
    private void loadTasks() {
        try (FileReader reader = new FileReader(FILE_NAME)) {
            Type taskListType = new TypeToken<ArrayList<Task>>() {}.getType();
            tasks = gson.fromJson(reader, taskListType);
            if (tasks == null) {
                tasks = new ArrayList<>();
            }
        } catch (IOException e) {
            // File might not exist on first run; initialize empty list
            tasks = new ArrayList<>();
        }
    }

    // Determine the next ID based on existing tasks
    private int getNextId() {
        return tasks.stream().mapToInt(Task::getId).max().orElse(0) + 1;
    }
}
