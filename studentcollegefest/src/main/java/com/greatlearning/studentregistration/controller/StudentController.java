package com.greatlearning.studentregistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.studentregistration.entity.Student;
import com.greatlearning.studentregistration.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	/*
	 * using the @Autowired annotation, spring injects the service object of
	 * concrete-class implementing given interface
	 */
	@Autowired
	StudentService studentService;

	/*
	 * URL: '/studentcollegefest/students/list' returns the model
	 * containing list of all students along with viewname "list-students"
	 */
	@RequestMapping("/list")
	public String showStudentList(Model model1) {

		List<Student> students = studentService.findAll();

		model1.addAttribute("students", students);

		return "list-students";
	}
	
	/*
	 * URL: "/studentcollegefest/students/showFormForAdd" takes Model
	 * object as an argument creates and returns an empty student model to be
	 * populated by the user also returns viewname "student-form"
	 */
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model2) {

		Student student1 = new Student();
		model2.addAttribute("student", student1);

		return "student-form";
	}
	
	/*
	 * URL:/studentcollegefest/students/showFormForUpdate
	 * takes student id using @RequestParam and a Model object as arguments.
	 * a record to be updated must be having an id, thus it retrieves the student
	 * record from database using its id and passes it to server using Model object
	 * Also returns viewname "student-form"
	 */
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int id, Model model3) {

		Student student2 = studentService.findById(id);
		model3.addAttribute("student", student2);

		return "student-form";
	}

	/*
	 * URL: /studentcollegefest/students/save
	 * takes all the user entered parameters using @RequestParam
	 * This button is used to save both new records and any updates
	 * 
	 * Case-1: New record will always have id=0
	 * 	new Student object is created using constructor
	 * 
	 * Case-2: Existing records will have non-zero ids
	 * in this case updated fields are set using setters
	 * 
	 * Saves the record and redirects to "students/list" page
	 */
	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {

		Student student3;

		if (id != 0) {
			student3 = studentService.findById(id);

			student3.setName(name);
			student3.setDepartment(department);
			student3.setCountry(country);
		} else {
			student3 = new Student(name, department, country);
		}

		studentService.save(student3);

		return "redirect:/students/list";
	}

	/*
	 * takes user entered student id using request parameter annotation
	 * deletes the record using service object
	 * 
	 * redirects to "students/list" page
	 */
	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") int id) {

		studentService.deleteById(id);

		return "redirect:/students/list";
	}

}
