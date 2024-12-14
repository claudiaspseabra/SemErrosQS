package com.example.qsproject.qsproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @version 1.0
 * @author Sem Erros
 */

/**
 *  Main application class for the Qsproject application, which runs the Spring Boot application and posts course and subject information at startup.
 */

@SpringBootApplication
public class QsprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(QsprojectApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return args -> {
			postInfo.postCourses();
			postInfo.postSubjects();
			postInfo.postUser();
		};
	}

}
