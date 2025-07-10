package com.example.taskmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class TaskEventPublisher {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void publish(Task task) {
        messagingTemplate.convertAndSend("/topic/tasks", task);
    }
}
