package com.dago.todo_api.dtos;

import com.dago.todo_api.models.Category;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.ZonedDateTime;

public record TodoDto(
        @NotNull(message = "L'identifiant doit être nul")
        long id,

        @NotEmpty(message = "Veuillez donner un titre à la tâche")
        String title,

        @NotEmpty(message = "Veuillez donner une description à la tâche")
        String description,

        @NotEmpty(message = "Veuillez donner un statut à la tâche")
        String status,

        ZonedDateTime startDate,

        boolean favorite,

        boolean done,

        Category category
) {
}
