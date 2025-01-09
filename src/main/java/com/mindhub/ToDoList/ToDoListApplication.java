package com.mindhub.ToDoList;

import com.mindhub.ToDoList.models.EntityUser;
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
	public CommandLineRunner initData(UserRepository userRepository){
		return args -> {
			EntityUser user = new EntityUser("sadas","sasa","sa");
			userRepository.save(user);
		};
	}

}
