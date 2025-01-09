package com.mindhub.ToDoList.services;

import com.mindhub.ToDoList.dtos.TaskDTO;
import com.mindhub.ToDoList.exceptions.TaskNotFoundException;
import com.mindhub.ToDoList.models.Task;

import java.util.List;

public interface TaskService {


    Task getTaskById(Long id) throws TaskNotFoundException;
    List<Task> getTasks();
    Task createTask (TaskDTO taskDTO);
    Task updateTask (Long id,TaskDTO taskDTO);
    void deleteTask(Long id);
}
