package com.mindhub.ToDoList.services;

import com.mindhub.ToDoList.dtos.TaskDTO;
import com.mindhub.ToDoList.dtos.TaskDTORequest;
import com.mindhub.ToDoList.dtos.UserDTO;
import com.mindhub.ToDoList.exceptions.TaskNotFoundException;
import com.mindhub.ToDoList.models.Task;

import java.util.List;

public interface TaskService {

    TaskDTO getTaskById(Long id) throws TaskNotFoundException;
    TaskDTO createTaskByAdmin (TaskDTORequest taskDTORequest);
    TaskDTO createTaskByUser (TaskDTO taskDTO, UserDTO userDTO);

    List<TaskDTO> getTasks();
    TaskDTO updateTask (Long id,TaskDTO taskDTO) throws TaskNotFoundException;
    void deleteTask(Long id) throws TaskNotFoundException;
}
