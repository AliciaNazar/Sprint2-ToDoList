package com.mindhub.ToDoList.services.impl;

import com.mindhub.ToDoList.dtos.TaskDTO;
import com.mindhub.ToDoList.exceptions.TaskNotFoundException;
import com.mindhub.ToDoList.models.Task;
import com.mindhub.ToDoList.services.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Override
    public Task getTaskById(Long id) throws TaskNotFoundException {
        return null;
    }

    @Override
    public List<Task> getTasks() {
        return List.of();
    }

    @Override
    public Task createTask(TaskDTO taskDTO) {
        return null;
    }

    @Override
    public Task updateTask(Long id, TaskDTO taskDTO) {
        return null;
    }

    @Override
    public void deleteTask(Long id) {

    }
}
