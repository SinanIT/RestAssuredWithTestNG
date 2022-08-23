package pojoExamples;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;

public class DummyAPIForStudentJsonArray {

	public static void main(String[] args) {
		
		Student s1 = new Student();
		s1.setAccountNo(12);
		s1.setBalance(90.34);
		s1.setEmail("sam@uol.com.br");
		s1.setFirst_name("Sam");
		s1.setLast_name("Deger");
		s1.setGender("Male");

		Student s2 = new Student();
		s2.setAccountNo(13);
		s2.setBalance(100.34);
		s2.setEmail("john@uol.com.br");
		s2.setFirst_name("John");
		s2.setLast_name("Hart");
		s2.setGender("Male");
		
		List<Student> students = new ArrayList<>();
		students.add(s1);
		students.add(s2);

		RestAssured
		.given()
		.log()
		.all()
		.body(students)
		.when()
		.get();
	}

}
