package com.mindhub.ToDoList.services;

import com.mindhub.ToDoList.dtos.UserDTO;
import com.mindhub.ToDoList.exceptions.UserNotFoundException;
import com.mindhub.ToDoList.models.EntityUser;
import com.mindhub.ToDoList.models.Task;

import java.util.List;

public interface UserService {

    //EntityUser getUserById(Long id) throws UserNotFoundException;
    UserDTO getUserById(Long id) throws UserNotFoundException;
    List<EntityUser> getUsers();
    UserDTO createUser (UserDTO userDTO);
    UserDTO updateUser (Long id,UserDTO userDTO) throws UserNotFoundException;
    void deleteUser(Long id) throws UserNotFoundException;







}








