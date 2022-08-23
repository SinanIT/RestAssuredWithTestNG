package pojoExamples.nestedJsonObjects;

import io.restassured.RestAssured;

public class CreateNestedJsonObjectPayload {

	public static void main(String[] args) {
		Employee employee = new Employee();
		employee.setFirstName("Sam");
		employee.setLastName("Deger");
		employee.setProffession("SDET");
		
		Address address = new Address();
		address.setNo(102);
		address.setStreetName("Creighton");
		address.setCity("Cary");
		address.setState("NC");
		address.setCountry("USA");
		
		employee.setAddress(address);
		
		RestAssured
		.given()
		.log()
		.all()
		.body(employee)
		.when()
		.post();
	}

}
