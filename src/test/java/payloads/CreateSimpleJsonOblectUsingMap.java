package payloads;

import java.util.LinkedHashMap;
import java.util.Map;

import io.restassured.RestAssured;

public class CreateSimpleJsonOblectUsingMap {
	public static void main(String[] args) {
		
		// if we pass diffrent type of data we need to use Object for values
		//Map<String, Object> jsonObjectPayload = new HashMap<>();
		Map<String, Object> jsonObjectPayload = new LinkedHashMap<>();
		jsonObjectPayload.put("id", 1);
		jsonObjectPayload.put("firstName", "Sinan");
		jsonObjectPayload.put("lastName", "Deger");
		jsonObjectPayload.put("married", true);
		jsonObjectPayload.put("salary", 170.50);
		
		RestAssured
		.given()
		.log()
		.all()//==> String, String {"firstName":"Sinan","lastName":"Deger","id":"1","salary":"170.50","married":"true"}
			  //==> String, Object {"firstName":"Sinan","lastName":"Deger","id":1,"salary":170.5,"married":true}
				
			  // to be able to get same order as we create in map we need to use linkedHashmap
			  //LinkedHashMap ==> {"id":1,"firstName":"Sinan","lastName":"Deger","married":true,"salary":170.5}
		
		.body(jsonObjectPayload)
		.get();
	
	}

}
