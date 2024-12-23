package com.dago.todo_api.repositories;

import com.dago.todo_api.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepo extends JpaRepository<Todo, Long> {

    List<Todo> findTodoByCategory_Id(long id);
}
