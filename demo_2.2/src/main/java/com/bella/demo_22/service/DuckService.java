package com.bella.demo_22.service;

import com.bella.demo_22.duck.Duck;
import reactor.core.publisher.Mono;

public interface DuckService {

    Mono<Duck> fetchRandomDuck();
}
