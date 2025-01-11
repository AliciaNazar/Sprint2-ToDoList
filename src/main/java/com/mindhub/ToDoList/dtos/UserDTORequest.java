package com.mindhub.ToDoList.dtos;

import com.mindhub.ToDoList.models.EntityUser;

public class UserDTORequest {


    private Long id;
    private String username;
    private String email;
    private String password;


    public UserDTORequest() {
    }

    public UserDTORequest(EntityUser user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static EntityUser toEntity(UserDTORequest userDTORequest){
        if(userDTORequest==null){
            return null;
        }
        EntityUser user = new EntityUser();
        user.setUsername(userDTORequest.getUsername());
        user.setEmail(userDTORequest.getEmail());
        user.setPassword(userDTORequest.getPassword());
        return user;
    }

}
