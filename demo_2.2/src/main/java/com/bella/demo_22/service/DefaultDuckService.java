package com.bella.demo_22.service;

import com.bella.demo_22.duck.Duck;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class DefaultDuckService implements DuckService {
    private final WebClient webClient;

    public DefaultDuckService(@Qualifier("duckWebClient") WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<Duck> fetchRandomDuck() {
        return webClient.get()
                .uri("/random")
                .exchangeToMono(this::handleResponse);
    }

    private Mono<Duck> handleResponse(ClientResponse response) {
        if (response.statusCode().is2xxSuccessful()) {
            return response.bodyToMono(Duck.class);
        } else {
            return response.bodyToMono(String.class)
                    .defaultIfEmpty("No body")
                    .flatMap(body -> Mono.error(new RuntimeException(
                            "Upstream error: " + response.statusCode() + " - " + body)));
        }
    }
}
