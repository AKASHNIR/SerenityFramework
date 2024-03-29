package com.studentapp.junit.studentsIdInfo;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.studentapp.cucumber.serenity.StudentSerenityStep;
import com.studentapp.testbase.TestBase;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;


@Concurrent(threads="4x")
@UseTestDataFrom("testdata/studentinfo.csv")
@RunWith(SerenityParameterizedRunner.class)
public class CreateStudentsDataDrivenTest extends TestBase {
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String programme;
	
	private String course;


	
	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProgramme() {
		return programme;
	}

	public void setProgramme(String programme) {
		this.programme = programme;
	}


	
	
	@Steps
	StudentSerenityStep steps;
	
	public StudentSerenityStep getSteps() {
		return steps;
	}

	public void setSteps(StudentSerenityStep steps) {
		this.steps = steps;
	}

	@Title("DataDriven Test for adding multiple students to the Student App")
	@Test
	public void createMultipleStudents(){
		
		ArrayList<String> courses = new ArrayList<String>();
		courses.add(course);
		
		steps.createStudent(firstName, lastName, email, programme, courses).statusCode(201);
		
		
	}

}
