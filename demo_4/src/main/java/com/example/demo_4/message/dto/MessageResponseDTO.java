package com.example.demo_4.message.dto;

import java.time.LocalDateTime;

public record MessageResponseDTO(
        Long id,
        String message,
        LocalDateTime createdAt,
        boolean pinned
) {
}
