package com.bella.demo_22.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class DuckWebClientConfig {
    @Bean
    public WebClient duckWebClient(WebClient.Builder builder) {
        return builder
                .baseUrl("https://random-d.uk/api/v2")
                .build();
    }
}
