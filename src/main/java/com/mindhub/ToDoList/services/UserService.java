package com.mindhub.ToDoList.services;

import com.mindhub.ToDoList.dtos.UserDTO;
import com.mindhub.ToDoList.dtos.UserDTORequest;
import com.mindhub.ToDoList.exceptions.UserNotFoundException;
import com.mindhub.ToDoList.models.EntityUser;

import java.util.List;

public interface UserService {

    UserDTO getUserById(Long id) throws UserNotFoundException;
    List<EntityUser> getUsers();
    UserDTO createUser (UserDTORequest userDTO);
    UserDTO updateUser (Long id, UserDTORequest userDTORequest) throws UserNotFoundException;
    void deleteUser(Long id) throws UserNotFoundException;







}








