package com.softeer.caart.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedOrigins("http://api.ca-art.store",
				"https://api.ca-art.store",
				"http://localhost:3000",
				"https://ca-art.store",
				"http://172.16.129.50:3000")
			.allowedMethods("GET", "POST")
			.maxAge(3000);
	}
}
