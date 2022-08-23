package converResponseToPojo;

import io.restassured.RestAssured;

public class NEstedJsonObjectToPojo {

	public static void main(String[] args) {
		
		EmployeeWithAddress employee = RestAssured
		.get("https://run.mocky.io/v3/c7991b87-9478-4c14-a706-c23a5add7817")
		.as(EmployeeWithAddress.class);
		
		String fn = employee.getFirstName();
		System.out.println(fn);

		Address address= employee.getAddress();
		System.out.println(address.getCity());
		
		System.out.println(employee.getAddress().getCountry());

	}

}
