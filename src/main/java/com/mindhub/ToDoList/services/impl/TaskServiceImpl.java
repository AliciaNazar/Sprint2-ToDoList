package com.mindhub.ToDoList.services.impl;

import com.mindhub.ToDoList.dtos.TaskDTO;
import com.mindhub.ToDoList.dtos.TaskDTORequest;
import com.mindhub.ToDoList.exceptions.TaskNotFoundException;
import com.mindhub.ToDoList.models.EntityUser;
import com.mindhub.ToDoList.models.Task;
import com.mindhub.ToDoList.repositories.TaskRepository;
import com.mindhub.ToDoList.repositories.UserRepository;
import com.mindhub.ToDoList.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public TaskDTO getTaskById(Long id) throws TaskNotFoundException {
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("No se encontró la tarea"));
        return Task.toDTO(task);
    }

    @Override
    public List<TaskDTO> getTasks() {
        List<Task> tasks= taskRepository.findAll();
        List<TaskDTO> tasksDTOS = tasks.stream()
                .map(Task::toDTO)
                .toList();

        return tasksDTOS;
    }

    @Override
    public TaskDTO createTask(TaskDTORequest taskDTORequest) {

        EntityUser user = this.userRepository.findById(taskDTORequest.getUser().getId())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        Task task = TaskDTORequest.toEntity(taskDTORequest,user); //creo una tarea y le asigno los valores de taskDTORequest
        task = this.taskRepository.save(task);
        return Task.toDTO(task);
    }

    @Override
    public TaskDTO updateTask(Long id, TaskDTO taskDTO) throws TaskNotFoundException{
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("No se encontró la tarea"));
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(taskDTO.getStatus());
        task = this.taskRepository.save(task);
        return Task.toDTO(task);

    }


    @Override
    public void deleteTask(Long id) throws TaskNotFoundException{
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("No se encontró la tarea"));
        taskRepository.deleteById(id);
    }

}
