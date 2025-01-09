package com.mindhub.ToDoList.dtos;

import com.mindhub.ToDoList.models.EntityUser;

public class UserDTO {

    private Long id;
    private String username;
    private String email;

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


    public static EntityUser toEntity(UserDTO userDTO){
        if(userDTO==null){
            return null;
        }
        EntityUser user = new EntityUser();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        return user;
    }
}
