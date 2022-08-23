package converResponseToPojo;

import io.restassured.RestAssured;

public class ConvertSimpleJsonArrayResponsToPojo {
	
	public static void main(String[] args) {
		
		
		Address[] addresses = RestAssured
		.get("https://run.mocky.io/v3/844b7156-6db3-4b56-bbdd-780bce5a806d")
		.as(Address[].class);
		
		System.out.println("Number of addresses: " + addresses.length );
		System.out.println(addresses[0].getCountry());
		System.out.println(addresses[1].getCity());
	}

}
