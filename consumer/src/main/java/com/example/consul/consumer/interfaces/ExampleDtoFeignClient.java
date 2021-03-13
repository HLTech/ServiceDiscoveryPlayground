package com.example.consul.consumer.interfaces;

import com.hltech.pact.gen.domain.client.feign.InteractionInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "provider", url = "localhost:8080")
public interface ExampleDtoFeignClient {

    @InteractionInfo(responseStatus = HttpStatus.OK)
    @GetMapping(value = "/example", consumes = MediaType.APPLICATION_JSON_VALUE)
    ExampleDto getExampleDto();
}
