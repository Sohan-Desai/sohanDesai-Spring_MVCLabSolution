package io.javabrains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.javabrains.model.Fullname;
import io.javabrains.model.GreatLearning;
import io.javabrains.serviceImpl.LibraryReadServiceImpl;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringSecurityApplication implements CommandLineRunner {

	@Autowired
	LibraryReadServiceImpl libraryReadServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
		System.out.println("Application booted successfully!");
	}

	@Override
	public void run(String... args) throws Exception {
		GreatLearning gl = GreatLearning.builder().courseName("Logging info with @Slf4j")
				.courseType("Spring Boot Example")
				.instructorName(Fullname.builder().firstName("Sohan").lastName("Desai").build())
				.build();

		log.info("Great Learning complex object creation -> {} ", gl);
		log.info("Fetch all libraries -> {} ", libraryReadServiceImpl.getAllLibraries());
		log.info("Fetch all libraries with no books -> {}", libraryReadServiceImpl.getAllLibrariesWithNoBooks());
	}

}
