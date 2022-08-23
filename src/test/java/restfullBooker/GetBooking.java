package restfullBooker;

import io.restassured.RestAssured;

public class GetBooking {
public static void main(String[] args) {
		
		
		//Build Request
		RestAssured
		.given()
		.log()
		.all()
		.baseUri("https://restful-booker.herokuapp.com/")
		.basePath("booking/{id}")
		.pathParam("id", 1659)
		//hit request get response
		.get()
		.then()
		.log()
		.all()
		.assertThat().statusCode(200);

	}

}
