package converResponseToPojo;

import io.restassured.RestAssured;

public class JsonObjectResponseToPojo {
	
	public static void main(String[] args) {
		
		
		Employee employee = RestAssured
		.given()
		.get("https://run.mocky.io/v3/554e2f34-283b-4ed4-8e00-510223a99580")
		.as(Employee.class);
		
		int age = employee.getAge();
		System.out.println(age);
	}

}
