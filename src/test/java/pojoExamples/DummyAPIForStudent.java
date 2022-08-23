package pojoExamples;

import io.restassured.RestAssured;

public class DummyAPIForStudent {

	public static void main(String[] args) {
		
		Student s1 = new Student();
		s1.setAccountNo(12);
		s1.setBalance(90.34);
		s1.setEmail("sam@uol.com.br");
		s1.setFirst_name("Sam");
		s1.setLast_name("Deger");
		s1.setGender("Male");


		RestAssured
		.given()
		.log()
		.all()
		.body(s1)
		.when()
		.get();
	}

}
