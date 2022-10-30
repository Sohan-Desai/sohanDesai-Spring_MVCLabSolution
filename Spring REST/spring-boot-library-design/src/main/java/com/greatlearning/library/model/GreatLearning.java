package com.greatlearning.library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GreatLearning {

	private String courseName;
	private String courseType;
	//private String instrutorName;
	private FullName instrutorName;
	
	public GreatLearning(String courseName){
		this.courseName = courseName;
	}
	
	public GreatLearning(String courseName,String courseType){
		this.courseName = courseName;
		this.courseType = courseType;
	}


	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public FullName getInstrutorName() {
		return instrutorName;
	}

	public void setInstrutorName(FullName instrutorName) {
		this.instrutorName = instrutorName;
	}
	
	

}
