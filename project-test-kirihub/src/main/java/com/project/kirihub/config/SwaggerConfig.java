package com.project.kirihub.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.project.kirihub"))
				.paths(PathSelectors.any()).build().apiInfo(metaInfo());
	}
	
	private ApiInfo metaInfo() {
		ApiInfo  apiInfo = new ApiInfo(
				"Projeto API REST para avaliação na KiriHUB",
				"API REST simula compra e busca taxa SELIC dos ultimos dias",
				"1.0",
				"Terms of Service",
				new Contact("Luciano Mota", "https://github.com/luciano-mota", "luciano.mota99@hotmail.com"),
				"Apache License Version 2.0",
				"https://www.apache.org/license.html", new ArrayList<VendorExtension>()
				
				);
		return apiInfo;
	}
}