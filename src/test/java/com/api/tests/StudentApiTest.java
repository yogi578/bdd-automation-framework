package com.api.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.RestService;
import com.api.model.Student;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class StudentApiTest {

	private RestService rest = new RestService();
	private static final String baseUrl = "http://localhost:8090/students/";

	@Test
	public void getStudent() {
		Student student = rest.get(baseUrl + "1", Student.class);
		Assert.assertEquals(student.getFirstName(), "Rahul");
		Assert.assertEquals(student.getLastName(), "Dravid");
	}

	@Test
	public void createAndValidateAndDeleteStudent() {
		int studentId=101;
		Student student= new Student();
		student.setId(studentId);
		student.setFirstName("John");
		student.setLastName("Snow");
		
		Map<String,String> headers=new HashMap<>();
		headers.put("Content-Type", "application/json");
		
		
		log.info("Student created: {}",rest.post(baseUrl+"createStudents", student,headers));
		
		Student responseStudent=rest.get(baseUrl+studentId, Student.class);
		Assert.assertEquals(responseStudent.getFirstName(), student.getFirstName());
		Assert.assertEquals(responseStudent.getLastName(), student.getLastName());
		
		log.info("student deleted : {}",rest.delete(baseUrl+studentId));
	}

}
