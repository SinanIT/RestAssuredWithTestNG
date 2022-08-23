package converResponseToPojo;

import io.restassured.RestAssured;

public class PartOfNstedJsonObjectToPojo {

	public static void main(String[] args) {
		
		Address adress = RestAssured
		.get("https://run.mocky.io/v3/c7991b87-9478-4c14-a706-c23a5add7817")
		.jsonPath()
		.getObject("address", Address.class);
		
		System.out.println(adress.getStreetName());
		

	}

}
