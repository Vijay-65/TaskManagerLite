package com.vijay.task_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.task_management_system.model.Task;
import com.vijay.task_management_system.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public void addTask(Task task) {
        repository.save(task);
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

    public void markAsCompleted(Long id) {
        Task task = repository.findById(id).orElse(null);
        if (task != null) {
            task.setCompleted(true);
            repository.save(task);
        }
    }
}