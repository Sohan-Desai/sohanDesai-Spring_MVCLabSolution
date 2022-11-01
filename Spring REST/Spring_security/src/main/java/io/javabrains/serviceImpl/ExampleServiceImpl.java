package io.javabrains.serviceImpl;

import org.springframework.stereotype.Service;

import io.javabrains.model.Fullname;
import io.javabrains.model.GreatLearning;
import io.javabrains.service.ExampleService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ExampleServiceImpl implements ExampleService {

	@Override
	public GreatLearning get() {
		log.info("Inside get() method");
		GreatLearning gl = GreatLearning.builder().courseName("Leveraging Builder pattern").courseType("Spring Boot")
				.instructorName(Fullname.builder().firstName("Sohan").lastName("Desai").build()).build();
		return gl;
	}

	@Override
	public GreatLearning customInfo(String courseName, String courseType, String firstName, String lastName) {
		log.info("Inside customInfo() method");
		GreatLearning gl = new GreatLearning(courseName, courseType,
				Fullname.builder().firstName(firstName).lastName(lastName).build());
		return gl;
	}
}
