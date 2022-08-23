package payloads;

import java.util.Map;

import io.restassured.RestAssured;

public class ConvertNestedJsonObjetResponseToJavaMApDESERI2 {

	public static void main(String[] args) {

		//deserilazation

		Map jsonResponse=  RestAssured
		.get("https://run.mocky.io/v3/0db5ac74-20e0-4c5c-9a49-0ab24726e0f1")
		.as(Map.class);
		String firstname = (String) jsonResponse.get("first_name");
		System.out.println(firstname);
		
		Map<String, String> skillsMap =  (Map<String, String>)jsonResponse.get("skills");
		System.out.println(skillsMap.get("name"));
		System.out.println(skillsMap.get("proficiency"));
	}

}
