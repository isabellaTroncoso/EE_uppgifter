package com.example.demo_4.message;

import com.example.demo_4.message.dto.MessageRequestDTO;
import com.example.demo_4.message.dto.MessageResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public Mono<MessageResponseDTO> createMessage(@RequestBody @Valid MessageRequestDTO request) {
        return messageService.createMessage(request)
                .flatMap(messageService::toResponse);
    }
}
/* Varför är det inte bra att behöva skriva in datum manuellt i JSON?
* Svar: Klienten eller kunden behöver veta exakt hur servern tolkar datum,
* vilket är onödigt och kan skapa buggar. Kräver extra kod på klienten för
* att alltid sätta rätt tidzon och format. OCH så kan man skriva i felaktigt format
*
* Följdfråga: Finns det ett bättre sätt?
* Svar: Ja, precis som man har autogenererat id så kan man göra det med datum.
*   LocalDateTime.now() , @CreationTimestamp*/
