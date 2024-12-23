package com.dago.todo_api.repositories;

import com.dago.todo_api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findUserByEmailAndPassword(String email, String password);
}

