package com.Treeleaf.TreeleafProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="BlogMs",description = "BlogApis",version = "2.8"))
public class TreeleafProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TreeleafProjectApplication.class, args);
	}

}
