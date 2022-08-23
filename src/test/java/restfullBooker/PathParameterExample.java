package restfullBooker;

import io.restassured.RestAssured;

public class PathParameterExample {
	
	public static void main(String[] args) {
		
		RestAssured
		.given()
			.log()
			.all()
			.baseUri("https://restful-booker.herokuapp.com/")
			.basePath("{basePath}/{bookingId}")
			.pathParam("basePath", "booking")
			.pathParam("bookingId", 1123)
		.when()
			.get()
		.then()
			.log()
			.all()
			.statusCode(200);
	}

}
