package restfullBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DeleteBooking {

	public static void main(String[] args) {
		RestAssured
		.given()
			.log()
			.all()
			.baseUri("https://restful-booker.herokuapp.com/")
			.basePath("booking/1980")
			.contentType(ContentType.JSON)
			.header("authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
		.when()
			.delete()
		.then()
			.log()
			.all()
			.assertThat()
			.statusCode(201);

	}

}
