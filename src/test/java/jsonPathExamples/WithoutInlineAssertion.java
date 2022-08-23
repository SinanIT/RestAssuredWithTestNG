package jsonPathExamples;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class WithoutInlineAssertion {

	public static void main(String[] args) {
		
		String response = 
				
				RestAssured
				.given()
				.log()
				.all()
				.baseUri("https://restful-booker.herokuapp.com/auth")
				.body("{\r\n"
						+ "    \"username\" : \"admin\",\r\n"
						+ "    \"password\" : \"password123\"\r\n"
						+ "}")
				.contentType(ContentType.JSON)
			.when()
			.post()
			.then()
			.log()
			.all()
			.extract()
			.asString();
		
		JsonPath js = new JsonPath(response);
		
		Assert.assertNotNull(js.get("token"));
		
	}
}
