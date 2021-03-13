package com.example.consul.provider;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@ActiveProfiles(value = "test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProviderApplicationTests {

	@LocalServerPort
	private int localServerPort;

	@Test
	void generateSwaggerTest() throws IOException {
		//given
		File swaggerDir = new File("build/swagger");
		swaggerDir.mkdirs();
		File swaggerJsonFile = new File(swaggerDir, "swagger.json");
		swaggerJsonFile.createNewFile();

		//when
		Response response = RestAssured.given().get(String.format("http://localhost:%d/v3/api-docs", localServerPort));

		//then
		assert response.statusCode() == 200;
		Files.write(Paths.get(swaggerJsonFile.getAbsolutePath()), response.getBody().asString().getBytes("UTF-8"));
	}
}
