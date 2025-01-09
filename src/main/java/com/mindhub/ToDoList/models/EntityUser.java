package com.mindhub.ToDoList.models;

import com.mindhub.ToDoList.dtos.UserDTO;
import com.mindhub.ToDoList.dtos.UserDTORequest;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class EntityUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;

    @OneToMany(mappedBy = "user")
    private Set<Task> tasks = new HashSet<>();


    public EntityUser() {
    }

    public EntityUser(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;

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

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }



    public static UserDTORequest toDTORequest(EntityUser user){
        if(user==null){
            return null;
        }
        UserDTORequest userDTO = new UserDTORequest(user);

        return userDTO;
    }

    public static UserDTO toDTO(EntityUser user){
        if(user==null){
            return null;
        }
        UserDTO userDTO = new UserDTO(user);

        return userDTO;
    }
}


