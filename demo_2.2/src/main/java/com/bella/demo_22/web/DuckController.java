package com.bella.demo_22.web;

import com.bella.demo_22.duck.Duck;
import com.bella.demo_22.service.DuckService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/ducks")
public class DuckController {
    private final DuckService duckService;

    public DuckController(DuckService duckService) {
        this.duckService = duckService;
    }

    @GetMapping("/random")
    public Mono<ResponseEntity<Duck>> getRandomDuck() {
        return duckService.fetchRandomDuck()
                .map(duck -> ResponseEntity.ok(duck))
                .onErrorResume(ex -> {
                    return Mono.just(ResponseEntity.status(HttpStatus.BAD_GATEWAY).build());
                });
    }

}
/*
DuckConfig -> Skapar WebClient -> @Configuration, @Bean -> Förbereder HTTP-klient för externa anrop
DefaultDuckService -> Gör API-anropet > @Service -> Hämtar data från https://random-d.uk
DuckController -> Hanterar HTTP requests -> @RestController -> Tar emot GET och returnerar JSON
Duck.java -> Modell / DTO -> Håller url och message från API:t
*/
