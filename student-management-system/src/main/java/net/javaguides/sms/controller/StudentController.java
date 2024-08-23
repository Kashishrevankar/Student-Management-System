package net.javaguides.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import net.javaguides.sms.dto.StudentDto;
import net.javaguides.sms.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@GetMapping("/students")
	public String listSudents(Model model) {
		List<StudentDto> students = studentService.getAllStudents();
		model.addAttribute("students", students);
		return "students";
	}
	
	// handler method to handle new student request
	@GetMapping("/students/new")
	public String newStudent(Model model) {
		 // student model object to store student form data
		StudentDto studentDto =new StudentDto();
		model.addAttribute("students", studentDto);
		return "create_student";
		
		
	}
	
	

}
