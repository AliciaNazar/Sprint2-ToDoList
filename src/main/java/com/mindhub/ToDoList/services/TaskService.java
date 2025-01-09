package com.mindhub.ToDoList.services;

import com.mindhub.ToDoList.dtos.TaskDTO;
import com.mindhub.ToDoList.exceptions.TaskNotFoundException;
import com.mindhub.ToDoList.models.Task;

import java.util.List;

public interface TaskService {

    TaskDTO getTaskById(Long id) throws TaskNotFoundException;
    TaskDTO createTask (TaskDTO taskDTO, Long idUser);

    List<Task> getTasks();
    TaskDTO updateTask (Long id,TaskDTO taskDTO) throws TaskNotFoundException;
    void deleteTask(Long id) throws TaskNotFoundException;
}
