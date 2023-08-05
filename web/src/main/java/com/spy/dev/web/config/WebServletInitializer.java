package com.spy.dev.web.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class WebServletInitializer extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(WebServletInitializer.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WebServletInitializer.class);
	}

}
