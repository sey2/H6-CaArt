package com.softeer.caart.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@OpenAPIDefinition(servers = {
	@Server(url = "http://localhost:8080", description = "Local server URL for development"),
	@Server(url = "https://api.ca-art.store", description = "Default server URL")
})
public class SwaggerConfig {
	@Bean
	public OpenAPI openAPI() {
		Info info = new Info()
			.title("CaArt API 명세서")
			.version("v0.0.1")
			.description("API documentation");
		return new OpenAPI()
			.components(new Components())
			.info(info);
	}
}
