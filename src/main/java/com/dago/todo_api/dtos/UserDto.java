package com.dago.todo_api.dtos;

import com.dago.todo_api.models.Category;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record UserDto(

        long id,

        @NotEmpty(message = "Veuillez renseigner le prénom")
        String firstName,

        @NotEmpty(message = "Veuillez renseigner le nom")
        String lastName,

        @NotEmpty(message = "Veuillez renseigner le nom")
        String password,

        @NotEmpty(message = "Veuillez renseigner votre mail")
        @Email(message = "Votre adresse mail n'est pas valide")
        String email,

        @NotEmpty(message = "Veuillez renseigner le nom d'utilisateur")
        String username,


        List<Category> categories
) {
}
