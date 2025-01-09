package com.mindhub.ToDoList.dtos;

import com.mindhub.ToDoList.models.EntityUser;
import com.mindhub.ToDoList.models.Task;

import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {

    private Long id;
    private String username;
    private String email;
    private List<TaskDTO> tasks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<TaskDTO> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDTO> tasks) {
        this.tasks = tasks;
    }

    public static EntityUser toEntity(UserDTO userDTO){
        if(userDTO==null){
            return null;
        }
        EntityUser user = new EntityUser();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setTasks(userDTO.getTasks()
                .stream()
                .map(TaskDTO::toEntity)//aqui a cada taskDTO lo transformo con mi función toEntity a task
                .toList());
        return user;
    }
}

