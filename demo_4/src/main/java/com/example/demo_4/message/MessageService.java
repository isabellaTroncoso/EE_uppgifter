package com.example.demo_4.message;

import com.example.demo_4.message.dto.MessageRequestDTO;
import com.example.demo_4.message.dto.MessageResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class MessageService {

    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Mono<Message> createMessage(MessageRequestDTO request) {

        logger.info("Creating new message: {}", request.message());


        Message message = new Message(
                null,
                request.message(),
                LocalDateTime.now(),
                true
        );


        return messageRepository.save(message);
    }

    public Mono<MessageResponseDTO> toResponse(Message message) {
        return Mono.just(new MessageResponseDTO(
                message.id(),
                message.message(),
                message.createdAt(),
                message.pinned()
        ));
    }
}
