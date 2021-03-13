package com.example.consul.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hltech.pact.gen.PactGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.File;

@SpringBootTest
@ActiveProfiles(value = "test")
class ConsumerApplicationTests {

	@Autowired
	ObjectMapper objectMapper;

	PactGenerator pactGenerator = new PactGenerator();

	@Test
	void generatePactFile() {
		//expect
		pactGenerator.writePactFiles("com.example.consul.consumer", "consumer", objectMapper, new File("build/pacts"));
	}
}
