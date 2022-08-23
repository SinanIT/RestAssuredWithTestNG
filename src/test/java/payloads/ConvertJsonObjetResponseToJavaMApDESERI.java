package payloads;

import java.util.Map;

import io.restassured.RestAssured;

public class ConvertJsonObjetResponseToJavaMApDESERI {

	public static void main(String[] args) {

		//deserilazation

		Map jsonResponse=  RestAssured
		.get("https://run.mocky.io/v3/ca9940c1-16a0-45d9-a94f-a3c54095baba")
		.as(Map.class);
		String firstname = (String) jsonResponse.get("first_name");
		System.out.println(firstname);
		jsonResponse.keySet().forEach(k->System.out.println(k));
		System.out.println(jsonResponse.size());

	}

}
