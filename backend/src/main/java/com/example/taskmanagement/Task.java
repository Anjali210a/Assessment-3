package com.example.taskmanagement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
public class Task {
    @Id
    private String id;
    private String title;
    private String description;
    private String assignee;
    private String status;
    private String projectId;

    // Getters and setters
}
