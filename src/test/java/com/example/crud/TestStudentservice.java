package com.example.crud;

import com.example.crud.Service.StudentService;
import com.example.crud.model.Student;
import com.example.crud.repository.studentrepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class TestStudentservice {

	@Autowired
	private StudentService studentService;
	private studentrepository studentrepository;

	@Order(1)
	@Test
	void addnewstudent() {


		Student student =
		studentService.addnewstudent(
				testData.name,
				testData.email,
				testData.username,
				testData.password
		);
		//checknull
		Assertions.assertNotNull(student);
		Assertions.assertNotNull(student.getId());

		//checkequal
		Assertions.assertEquals(testData.name,student.getName());
		Assertions.assertEquals(testData.email,student.getEmail());
		Assertions.assertEquals(testData.username,student.getUsername());
		boolean ismatch =studentService.matchpassword(testData.password,student.getPassword());
		Assertions.assertTrue(ismatch);
	}

	@Order(3)
	@Test
	void deleteStudent(){

		Optional<Student> opt = studentService.findStudentByEmail(testData.email);
		Assertions.assertTrue(opt.isPresent());
		Student student = opt.get();
		studentService.deleteStudent(student.getId());

		Optional<Student> optdelete = studentService.findStudentByEmail(testData.email);
		Assertions.assertTrue(optdelete.isEmpty());


	}

	@Order(2)
	@Test
	void update(){
		Optional<Student> opt = studentService.findStudentByEmail(testData.email);
			Assertions.assertTrue(opt.isPresent());

			Student student =opt.get();

			Student updatestuent = studentService.update(student.getId(),testupdate.name,testData.email);

			Assertions.assertNotNull(updatestuent);
			Assertions.assertEquals(testData.name,student.getName());




	}


	interface testData{
		String name="unittest";
		String email="emailtest";
		String username="testt";
		String password ="123";
	}

	interface testupdate{
		String name="testupdate";
	}

}
