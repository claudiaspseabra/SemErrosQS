package com.example.qsproject.qsproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QsprojectApplication {

	// RESOLVER PROBLEMA IDS COURSE ID DENTRO DO SUBJECT ID

	public static void main(String[] args) {
		SpringApplication.run(QsprojectApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return args -> {
			postInfo.postCourses();
			postInfo.postSubjects();
		};
	}
}
