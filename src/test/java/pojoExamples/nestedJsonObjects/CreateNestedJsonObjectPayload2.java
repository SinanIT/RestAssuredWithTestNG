package pojoExamples.nestedJsonObjects;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;

public class CreateNestedJsonObjectPayload2 {

	public static void main(String[] args) {
		
		Employee2 employee = new Employee2();
		
		employee.setFirstName("Sam");
		employee.setLastName("Deger");
		employee.setProffession("SDET");
		
				Address address = new Address();
				address.setNo(102);
				address.setStreetName("Creighton");
				address.setCity("Cary");
				address.setState("NC");
				address.setCountry("USA");
				
				Address address2 = new Address();
				address2.setNo(122);
				address2.setStreetName("Saticoy");
				address2.setCity("LA");
				address2.setState("CA");
				address2.setCountry("USA");
				
				List<Address> allAddresses = new ArrayList<>();
				allAddresses.add(address);
				allAddresses.add(address2);
		
		employee.setAddress(allAddresses);
		
		RestAssured
		.given()
		.log()
		.all()
		.body(employee)
		.when()
		.post();
	}

}
