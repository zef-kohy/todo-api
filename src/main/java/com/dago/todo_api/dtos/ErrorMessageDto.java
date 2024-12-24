package com.dago.todo_api.dtos;

import java.time.LocalDateTime;

public record ErrorMessageDto(
        String message,
        String description,
        LocalDateTime timeStamp
) {
}
