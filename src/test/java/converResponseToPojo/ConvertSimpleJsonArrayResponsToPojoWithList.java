package converResponseToPojo;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class ConvertSimpleJsonArrayResponsToPojoWithList {
	
	public static void main(String[] args) {
		
		
		List<Address> addresses = RestAssured
		.get("https://run.mocky.io/v3/844b7156-6db3-4b56-bbdd-780bce5a806d")
		.as(new TypeRef<List<Address>>() {});
		
		System.out.println("Number of addresses: " + addresses.size() );
		System.out.println(addresses.get(0).getCountry());
		System.out.println(addresses.get(1).getCity());
	}

}
