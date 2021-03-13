package com.example.consul.provider.api;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/example")
public class ExampleController {

    @GetMapping
    @Operation(summary = "Get example list", method = "GET")
    ExampleDto getExample() {
        return new ExampleDto("Hello");
    }
}
