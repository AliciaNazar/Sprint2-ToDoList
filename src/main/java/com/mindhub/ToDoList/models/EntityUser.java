package com.mindhub.ToDoList.models;

import com.mindhub.ToDoList.dtos.UserDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class EntityUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Task> tasks = new ArrayList<>();


    public EntityUser() {
    }

    public EntityUser(String username, String password, String email, List<Task> tasks) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.tasks=tasks;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public static UserDTO toDTO(EntityUser user){
        if(user==null){
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setTasks(user.getTasks()
                .stream()
                .map(Task::toDTO)
                .toList());
        return userDTO;
    }
}


