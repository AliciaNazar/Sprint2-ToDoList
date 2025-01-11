package com.mindhub.ToDoList.services.impl;

import com.mindhub.ToDoList.dtos.UserDTO;
import com.mindhub.ToDoList.dtos.UserDTORequest;
import com.mindhub.ToDoList.exceptions.UserNotFoundException;
import com.mindhub.ToDoList.models.EntityUser;
import com.mindhub.ToDoList.repositories.UserRepository;
import com.mindhub.ToDoList.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO getUserById(Long id) throws UserNotFoundException {
        EntityUser user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
        return new UserDTO(user);
    }

    @Override
    public List<EntityUser> getUsers() {
        return List.of();
    }

    @Override
    public UserDTO createUser(UserDTORequest userDTORequest) {
        EntityUser user = UserDTORequest.toEntity(userDTORequest);
        user = this.userRepository.save(user); //reasigné user para ver cómo se actualizó el id (ya que no se le asigna hasta que se añade a la bd)
        return new UserDTO(user);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTORequest userDTORequest) throws UserNotFoundException{
        EntityUser user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());
        user.setUsername(userDTORequest.getUsername());
        user.setEmail(userDTORequest.getEmail());
        user.setPassword(userDTORequest.getPassword());
        user = this.userRepository.save(user);
        return new UserDTO(user);
    }

    @Override
    public void deleteUser(Long id) throws UserNotFoundException{
        userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());
        userRepository.deleteById(id);
    }
}
