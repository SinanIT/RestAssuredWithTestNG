package jsonPathExamples;

import org.hamcrest.Matchers;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class WithInlineAssertion {

	public static void main(String[] args) {
		
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
			.body("token", Matchers.notNullValue(null))
			.body("token.length()", Matchers.is(15))
			.body("token.length()", Matchers.equalTo(15))
			.body("token", Matchers.matchesRegex("^[a-z0-9]+$"));
		
	}
}
