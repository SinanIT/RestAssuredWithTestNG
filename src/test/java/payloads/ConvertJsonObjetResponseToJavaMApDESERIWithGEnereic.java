package payloads;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class ConvertJsonObjetResponseToJavaMApDESERIWithGEnereic {

	public static void main(String[] args) {

		//deserilazation

		Map <String, Object>jsonResponse=  RestAssured
		.get("https://run.mocky.io/v3/ca9940c1-16a0-45d9-a94f-a3c54095baba")
		.as(new TypeRef<Map<String,Object>>() {});
		
		String firstname = (String) jsonResponse.get("first_name");
		System.out.println(firstname);
		jsonResponse.keySet().forEach(k->System.out.println(k));

	}

}
