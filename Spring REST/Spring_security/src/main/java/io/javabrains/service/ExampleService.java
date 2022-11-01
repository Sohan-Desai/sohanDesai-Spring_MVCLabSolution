package io.javabrains.service;

import io.javabrains.model.GreatLearning;

public interface ExampleService {

	GreatLearning get();

	GreatLearning customInfo(String courseName, String courseType, String firstName, String lastName);

}