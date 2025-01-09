package com.mindhub.ToDoList.services.impl;

import com.mindhub.ToDoList.dtos.TaskDTO;
import com.mindhub.ToDoList.exceptions.TaskNotFoundException;
import com.mindhub.ToDoList.models.EntityUser;
import com.mindhub.ToDoList.models.Task;
import com.mindhub.ToDoList.repositories.TaskRepository;
import com.mindhub.ToDoList.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public TaskDTO getTaskById(Long id) throws TaskNotFoundException {
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("No se encontró la tarea"));
        return Task.toDTO(task);
    }

    @Override
    public List<Task> getTasks() {
        return List.of();
    }

    @Override
    public TaskDTO createTask(TaskDTO taskDTO, Long idUser) {
        Task task = TaskDTO.toEntity(taskDTO);
        EntityUser user = new EntityUser();
        user.setId(idUser);
        task.setUser(user);
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
