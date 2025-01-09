package com.mindhub.ToDoList.repositories;

import com.mindhub.ToDoList.models.EntityUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<EntityUser,Long> {
}
