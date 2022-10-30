package io.javabrains;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.javabrains.entity.GreatLearning;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringSecurityApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
		System.out.println("Application booted successfully!");
	}

	@Override
	public void run(String... args) throws Exception {

//		GreatLearning gl = new GreatLearning();
//		gl.setCourseName("Software testing with Lombok");
//		System.out.println(gl.getCourseName());
//		System.out.println("Course : " + gl);
	}

}
