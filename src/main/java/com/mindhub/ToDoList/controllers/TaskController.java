package com.mindhub.ToDoList.controllers;

import com.mindhub.ToDoList.dtos.TaskDTO;
import com.mindhub.ToDoList.exceptions.TaskNotFoundException;
import com.mindhub.ToDoList.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable("id") Long id) throws TaskNotFoundException{
        TaskDTO taskDTO = this.taskService.getTaskById(id);
        return ResponseEntity.ok(taskDTO);
    }

    @PostMapping("/{idUser}")
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO, @PathVariable("idUser") Long id){
        TaskDTO task = this.taskService.createTask(taskDTO, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable("id") Long id) throws TaskNotFoundException{
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(
        @PathVariable("id") Long id,
        @RequestBody TaskDTO taskDTO)
        throws TaskNotFoundException{
        TaskDTO task = this.taskService.updateTask(id,taskDTO);
        return ResponseEntity.ok(task);
    }


}
