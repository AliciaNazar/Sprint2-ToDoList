package com.mindhub.ToDoList.dtos;

import com.mindhub.ToDoList.models.Task;
import com.mindhub.ToDoList.models.TaskStatus;

public class TaskDTO {

    private Long id;
    private String title;
    private String description;
    private TaskStatus status;

    public TaskDTO() {
    }
    public TaskDTO(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.status = task.getStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }


    public static Task toEntity(TaskDTO taskDTO){
        Task task = new Task();
        task.setStatus(taskDTO.getStatus());
        task.setDescription(taskDTO.getDescription());
        task.setTitle(taskDTO.getTitle());
        return task;
    }

}
