package com.mindhub.ToDoList.controllers;

import com.mindhub.ToDoList.dtos.TaskDTO;
import com.mindhub.ToDoList.dtos.TaskDTORequest;
import com.mindhub.ToDoList.exceptions.TaskNotFoundException;
import com.mindhub.ToDoList.services.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Operation(summary = "Get a task by ID", description = "Retrieves a task by the specified id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task retrieved successfully."),
            @ApiResponse(responseCode = "404", description = "Task not found.")
    })
    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable("id") Long id) throws TaskNotFoundException{
        TaskDTO taskDTO = this.taskService.getTaskById(id);
        return ResponseEntity.ok(taskDTO);
    }

    @Operation(summary = "Get all task", description = "Retrieves a list of all tasks.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of tasks successfully retrieved"),
    })
    @GetMapping
    public ResponseEntity<List<TaskDTO>> getTasks(){
        List<TaskDTO> tasks = this.taskService.getTasks();
        return ResponseEntity.ok(tasks);
    }

    @Operation(summary = "Create a new task", description = "Creates a new task.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Task created successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTORequest taskDTORequest){
        TaskDTO taskDTO = this.taskService.createTask(taskDTORequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskDTO);
    }

    @Operation(summary = "Delete a task", description = "Deletes an existing task by the provided ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Task successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Task not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable("id") Long id) throws TaskNotFoundException{
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Update a task", description = "Updates the information of an existing task.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task successfully updated"),
            @ApiResponse(responseCode = "404", description = "Task not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(
        @PathVariable("id") Long id,
        @RequestBody TaskDTO taskDTO)
        throws TaskNotFoundException{
        TaskDTO task = this.taskService.updateTask(id,taskDTO);
        return ResponseEntity.ok(task);
    }


}
