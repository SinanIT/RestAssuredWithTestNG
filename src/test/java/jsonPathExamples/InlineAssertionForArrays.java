package jsonPathExamples;

import org.hamcrest.Matchers;
import io.restassured.RestAssured;

public class InlineAssertionForArrays {

	public static void main(String[] args) {
		
		RestAssured
				.given()
				.log()
				.all()
				.baseUri("https://restful-booker.herokuapp.com/booking")
			.when()
				.get()
			.then()
			.log()
			.all()
			.body("bookingid", Matchers.hasItems(1408,1190));
		
	}
}
