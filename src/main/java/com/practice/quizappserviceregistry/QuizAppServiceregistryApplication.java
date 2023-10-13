package com.practice.quizappserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class QuizAppServiceregistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizAppServiceregistryApplication.class, args);
	}

}
