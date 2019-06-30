package com.studentapp.cucumber.serenity;

import java.util.HashMap;
import java.util.List;

import com.studentapp.model.StudentClass;
import com.studentapp.utils.ResuseableSpecifications;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class StudentSerenityStep {
	
	
	
	@Step("Creating the student with firstName:{0}, lastName:{1}, email:{2}, programme{3},courses{4} ")
	public ValidatableResponse createStudent(String firstName, String lastName, String email, String programme,
			List<String> courses) {

		StudentClass student = new StudentClass();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setEmail(email);
		student.setProgramme(programme);
		student.setProgramme(programme);
		student.setCourses(courses);

		return SerenityRest.rest().given().spec(ResuseableSpecifications.getGenericRequestSpec()).contentType(ContentType.JSON).log().all().when().body(student).post().then();

		
	}
	
	
	@Step("Getting the student information with firstName :{0}")
	
	public HashMap<String, Object> getStudentInfoFirstName(String firstName){
		
		String p1="findAll{it.firstName=='";
		String p2="'}.get(0)";

		
		return SerenityRest.rest().given().get("/list").then().log().all().statusCode(200).extract().path(p1+firstName+p2);
		
		
		
	
		
	}
	
	
	@Step("updating the student information with studentID: {0} ,firstName:{1}, lastName:{2}, email:{3}, programme{4},courses{5} ")
	public ValidatableResponse updateStudent(int studentId,String firstName, String lastName, String email, String programme,
			List<String> courses) {

		StudentClass student = new StudentClass();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setEmail(email);
		student.setProgramme(programme);
		student.setProgramme(programme);
		student.setCourses(courses);

		return SerenityRest.rest().given().spec(ResuseableSpecifications.getGenericRequestSpec()).log().all().when().body(student).put("/"+studentId).then();

		
	}

	
	
	@Step("Deleting student information with ID :{0}")
	public void deleteStudent(int studentId){
		
		SerenityRest.rest().given().when().delete("/"+studentId);
		
		
		
	}
	
	
	@Step("Getting 	information of student with ID:{0}")
	public ValidatableResponse getStudentById (int studentId){
		
		
		return SerenityRest.rest().given().when().get("/"+studentId).then();
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
