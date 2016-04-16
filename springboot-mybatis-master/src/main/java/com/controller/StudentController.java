package com.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.po.Student;
import com.service.StudentService;

@Controller
public class StudentController {

	private Logger logger = Logger.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;

	@RequestMapping("/getAllStudentInfo")
	@ResponseBody
	public List<Student> getAllStudentInfo() {
		List<Student> studentList = studentService.getAllStudentInfo();

		if (studentList != null && studentList.size() > 0) {
			for (Student student : studentList) {
				System.out.println(student);
				logger.info(student);
			}
		}
		return studentList;
	}
}