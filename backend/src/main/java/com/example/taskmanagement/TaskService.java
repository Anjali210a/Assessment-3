package com.example.taskmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepo;

    @Autowired
    private TaskEventPublisher publisher;

    public List<Task> getAll() {
        return taskRepo.findAll();
    }

    public Task create(Task task) {
        Task saved = taskRepo.save(task);
        publisher.publish(saved);
        return saved;
    }

    public Task update(String id, Task task) {
        task.setId(id);
        Task updated = taskRepo.save(task);
        publisher.publish(updated);
        return updated;
    }

    public void delete(String id) {
        taskRepo.deleteById(id);
    }
}
