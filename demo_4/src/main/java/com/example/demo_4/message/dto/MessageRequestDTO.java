package com.example.demo_4.message.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record MessageRequestDTO(
        @NotBlank(message = "Message text cannot be blank")
        @Size(max = 255, message = "Message must be at most 255 characters long")
        String message
) {
}
