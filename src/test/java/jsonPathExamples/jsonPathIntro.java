package jsonPathExamples;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class jsonPathIntro {
	
	@Test
	public void jsonPathDemo() {
		
		String json = "{\r\n"
				+ "  \"firstname\": \"Jim\",\r\n"
				+ "  \"lastname\": \"Brown\"\r\n"
				+ "}";
		// Get the json path instance of given json document
		JsonPath jsonPath = new JsonPath(json);
		String firstname = jsonPath.getString("firstname");
		System.out.println(firstname);//Jim
		
		Object fname = jsonPath.getString("firstname");
		System.out.println(fname);//Jim
		
		System.out.println((Object)jsonPath.get("$")); //{firstname=Jim, lastname=Brown}
		
		System.out.println(jsonPath.getString("$")); //[firstname:Jim, lastname:Brown]
		
		System.out.println((Object)jsonPath.get()); //{firstname=Jim, lastname=Brown}
		
		System.out.println(jsonPath.getString(""));//[firstname:Jim, lastname:Brown]
		
	}

}
