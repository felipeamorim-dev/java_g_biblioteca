package com.felipesa.g_biblioteca.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.felipesa.g_biblioteca"))
				.paths(PathSelectors.regex("/api.*"))
				.build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("BOOK LOAN REST API",
				"API Rest para o gerenciamento de emprestimos de livros em uma biblioteca", "1.0", "Terms of service",
				new Contact("Felipe Amorim", "www.linkedin.com/in/felipeamorim-dev", "felipeamorim.dev@gmail.com"),
				"Apache License Version 2.0", "https:www.apache.org/licesen.html", Collections.emptyList());
	}
}
