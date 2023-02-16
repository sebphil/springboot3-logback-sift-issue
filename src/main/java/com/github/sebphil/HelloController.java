package com.github.sebphil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public Mono<String> hello(String name, String logCategory) {
        MDC.put("logCategory", logCategory);
        LOGGER.info("saying hello to " + name);
        return Mono.just("hello " + name + "!");
    }
}
