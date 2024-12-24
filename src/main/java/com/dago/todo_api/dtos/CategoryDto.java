package com.dago.todo_api.dtos;

import com.dago.todo_api.models.Todo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CategoryDto(

        @NotNull(message = "L'identifiant doit être nul")
        long id,

        @NotEmpty(message = "Veuillez donner un nom à la catégorie")
        String name,

        @NotBlank(message = "La description ne doit être vide ou avoir d'espace")
        String description,

        UserDto userDto,

        List<Todo> todoList
) {
}
