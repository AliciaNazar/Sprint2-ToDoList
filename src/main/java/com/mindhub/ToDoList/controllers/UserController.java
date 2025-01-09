package com.mindhub.ToDoList.controllers;

import com.mindhub.ToDoList.dtos.UserDTO;
import com.mindhub.ToDoList.exceptions.UserNotFoundException;
import com.mindhub.ToDoList.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long id) throws UserNotFoundException {
        UserDTO userDTO = this.userService.getUserById(id);
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        UserDTO user = this.userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) throws UserNotFoundException{
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(
            @PathVariable("id") Long id,
            @RequestBody UserDTO userDTO)
        throws UserNotFoundException {
        UserDTO user = this.userService.updateUser(id,userDTO);
        return ResponseEntity.ok(user);
    }




}
