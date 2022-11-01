package io.javabrains.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.model.Fullname;
import io.javabrains.model.GreatLearning;
import io.javabrains.service.ExampleService;
import io.swagger.annotations.ApiOperation;

@RestController
public class ExampleController {

	@Autowired
	private ExampleService exampleServiceImpl;

	@ApiOperation(value = "Provides information about this course")
	@GetMapping("/info")
	public GreatLearning get() {
		return exampleServiceImpl.get();
	}

	// user input through builder pattern injection
	@ApiOperation(value = "Allows you to customize information about a course")
	@PostMapping("/customInfo")
	public GreatLearning customInfo(String courseName, String courseType, String firstName, String lastName) {
		return exampleServiceImpl.customInfo(courseName, courseType, firstName, lastName);
	}
}
