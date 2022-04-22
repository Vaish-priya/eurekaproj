package com.ibm.application;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController 
@ComponentScan({"com.ibm.*"})
@Configuration
@EnableAutoConfiguration
@EnableWebMvc
@SpringBootApplication
public class CrsIbmProfessorProducerApiMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrsIbmProfessorProducerApiMicroserviceApplication.class, args);
	}

}

