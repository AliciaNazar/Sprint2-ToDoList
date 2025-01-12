package com.mindhub.ToDoList;

import com.mindhub.ToDoList.models.EntityUser;
import com.mindhub.ToDoList.models.RoleType;
import com.mindhub.ToDoList.models.Task;
import com.mindhub.ToDoList.models.TaskStatus;
import com.mindhub.ToDoList.repositories.TaskRepository;
import com.mindhub.ToDoList.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ToDoListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoListApplication.class, args);
	}

	@Autowired
	PasswordEncoder passwordEncoder; //en este caso para encriptar la password en la bd


	@Bean
	public CommandLineRunner initData(UserRepository userRepository, TaskRepository taskRepository){
		return args -> {
			EntityUser user = new EntityUser("ali",passwordEncoder.encode("ali1234"),"ali@gmail.com");
			userRepository.save(user);
//			Task task =new Task("Estudiar","progra", TaskStatus.PENDING,user);
//			taskRepository.save(task);
		};
	}

}
