package restfullBooker;

import io.restassured.RestAssured;

public class PathParameterExample3 {
	
	public static void main(String[] args) {
		
		RestAssured
		.given()
			.log()
			.all()

			.pathParam("basePath", "booking")
		.when()
			.get("https://restful-booker.herokuapp.com/{basePath}/{bookingId}", 1659)
		.then()
			.log()
			.all()
			.statusCode(200);
	}

}
