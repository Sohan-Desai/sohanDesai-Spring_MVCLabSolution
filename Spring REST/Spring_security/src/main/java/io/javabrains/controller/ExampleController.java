package io.javabrains.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.entity.GreatLearning;
import io.swagger.annotations.ApiOperation;

@RestController
public class ExampleController {

	
	@ApiOperation(value = "Provides information about this course")
	@GetMapping("/info")
	public GreatLearning get() {
		GreatLearning gl = new GreatLearning("Learn Controllers in Spring Boot", "Information Technology",
				"Sohan Desai");
		return gl;
	}

	@ApiOperation(value = "Allows you to customize information about a course")
	@PostMapping("/customInfo")
	public GreatLearning customInfo(String courseName, String courseType, String instructorName) {
		GreatLearning gl = new GreatLearning(courseName, courseType, instructorName);
		return gl;
	}
}
