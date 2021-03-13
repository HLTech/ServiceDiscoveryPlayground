package com.example.consul.provider.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
class ExampleDto {

    @Schema(example = "field", required = true)
    private final String field;
}
