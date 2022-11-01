package io.javabrains.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GreatLearning {

	private String courseName;
	private String courseType;
	private Fullname instructorName;


}
