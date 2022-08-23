package payloads;

import java.util.LinkedHashMap;
import java.util.Map;

import io.restassured.RestAssured;

public class CreateNestedJsonObjectsWithMap {
	
	public static void main(String[] args) {
		
		
		Map<String, Object> payload = new LinkedHashMap<>();
		payload.put("id", 1);
		payload.put("firstName", "Sinan");
		payload.put("lastName", "Deger");
		payload.put("married", true);
		
		//nested part of json in map
		Map<String, Object> address = new LinkedHashMap<>();
		address.put("no", "81");
		address.put("street", "Creighton");
		address.put("city", "Cary");
		address.put("state", "NC");
		
		payload.put("address", address);
		
		RestAssured
		.given()
		.log()
		.all() //{"id":1,"firstName":"Sinan","lastName":"Deger","married":true,"address":{"no":"81","street":"Creighton","city":"Cary","state":"NC"}}
		.body(payload)
		.get();
		
	}

}
