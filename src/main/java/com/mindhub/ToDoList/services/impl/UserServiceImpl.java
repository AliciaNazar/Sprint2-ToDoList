package com.mindhub.ToDoList.services.impl;

import com.mindhub.ToDoList.dtos.UserDTO;
import com.mindhub.ToDoList.dtos.UserDTORequest;
import com.mindhub.ToDoList.exceptions.UserNotFoundException;
import com.mindhub.ToDoList.models.EntityUser;
import com.mindhub.ToDoList.models.Enums.RoleType;
import com.mindhub.ToDoList.repositories.UserRepository;
import com.mindhub.ToDoList.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public UserDTO getUserById(Long id) throws UserNotFoundException {
        EntityUser user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
        return new UserDTO(user);
    }

    @Override
    public UserDTO getUserByUsername(String username) throws UserNotFoundException{
        EntityUser user = userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException());
        return new UserDTO(user);
    }

    @Override
    public List<UserDTO> getUsers() {
        List<EntityUser> users = userRepository.findAll();
        List<UserDTO> userDTOS = users.stream()
                .map(user -> new UserDTO(user))
                .toList();
        return userDTOS;
    }

    @Override
    public UserDTO updateUser(Long id, UserDTORequest userDTORequest) throws UserNotFoundException{
        EntityUser user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());
        user.setEmail(userDTORequest.getEmail());
        user.setPassword(passwordEncoder.encode(userDTORequest.getPassword()));
        user = this.userRepository.save(user);
        return new UserDTO(user);
    }

    @Override
    public void deleteUser(Long id) throws UserNotFoundException{
        userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());
        userRepository.deleteById(id);
    }


    @Override
    public UserDTO registerUserByAdmin(UserDTORequest userDTORequest) {
        if (userRepository.existsByUsername(userDTORequest.getUsername())) {
            throw new RuntimeException("Username already exists");
        }else {
            EntityUser user = new EntityUser();
            user.setUsername(userDTORequest.getUsername());
            user.setPassword(passwordEncoder.encode(userDTORequest.getPassword()));
            user.setEmail(userDTORequest.getEmail());
            user.setRoleType(userDTORequest.getRoleType());
            user = userRepository.save(user);
        return new UserDTO(user);
        }
    }

    @Override
    public UserDTO registerUser(UserDTORequest userDTORequest) {
        if (userRepository.existsByUsername(userDTORequest.getUsername())) {
            throw new RuntimeException("Username already exists");
        }else {
            EntityUser user = new EntityUser();
            user.setUsername(userDTORequest.getUsername());
            user.setPassword(passwordEncoder.encode(userDTORequest.getPassword()));
            user.setEmail(userDTORequest.getEmail());
            user = userRepository.save(user);
            return new UserDTO(user);
        }
    }



}
