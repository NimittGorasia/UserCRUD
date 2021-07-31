package com.example.userCRUD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.userCRUD.model.User;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class UserCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserCrudApplication.class, args);
	}

	
	 @Bean 
	   public List<User> listOfUsers(){
		List<User> list = new ArrayList<>();
	    return list;      
	  }
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/user/**"))
				.build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "User CRUD Demo API ", 
	      "A Demo app for CRUD Operations", 
	      "User CRUD", 
	      "Terms of service", 
	      new Contact("Nimitt Gorasia", "www.example.com", "gorasianimitt08@gmail.com"), 
	      "License of API", "API license URL", Collections.emptyList());
	}
}
