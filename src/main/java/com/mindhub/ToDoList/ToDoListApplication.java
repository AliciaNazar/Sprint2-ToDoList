package com.mindhub.ToDoList;

import com.mindhub.ToDoList.models.EntityUser;
import com.mindhub.ToDoList.models.Task;
import com.mindhub.ToDoList.models.TaskStatus;
import com.mindhub.ToDoList.repositories.TaskRepository;
import com.mindhub.ToDoList.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ToDoListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoListApplication.class, args);
	}



	@Bean
	public CommandLineRunner initData(UserRepository userRepository, TaskRepository taskRepository){
		return args -> {
			EntityUser user = new EntityUser("as","as","as");
			userRepository.save(user);
//			Task task =new Task("Estudiar","progra", TaskStatus.PENDING,user);
//			taskRepository.save(task);
		};
	}

}
