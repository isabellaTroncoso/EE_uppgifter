package com.example.demo_4.message.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MessageNotFoundException.class)
    public ResponseEntity<String> handleMessageNotFound(MessageNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }
}

/*När används @RestControllerAdvice?
* Svar: Den fångar exceptions som kastas i controllers och låter dig returnera
* konsekventa HTTP-responsen med statuskod och meddelande. Man slipper duplicera try/catch i varje controller.
*
* Om vi exkluderar annotationen, vad händer?
* Svar: Exceptions från controllers kommer INTE att hanteras av vår globala handler.
* Klienten får istället standardfel, oftast HTTP 500 Internal Server Error
*
* Finns det något man behöver veta om @ControllerAdvice i WebFlux?
* Svar: Kan returnera vanliga ResponseEntity eller Mono<ResponseEntity<?>>.
* Fungerar som i Spring MVC, men för reaktiva controllers.
* Gör att exceptions hanteras centralt utan att bryta reaktivitet (Async).*/


