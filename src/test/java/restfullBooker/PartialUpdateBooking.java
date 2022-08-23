package restfullBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PartialUpdateBooking {

	public static void main(String[] args) {
		
		
		RestAssured
		.given()
			.log()
			.all()
			.baseUri("https://restful-booker.herokuapp.com/")
			.basePath("booking/1744")
			.body("{\r\n"
					+ "    \"firstname\" : \"Jony\",\r\n"
					+ "    \"lastname\" : \"Green\"\r\n"
					+ "}")
			.contentType(ContentType.JSON)
			.header("authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
		.when()
			.patch()
		.then()
			.log()
			.all()
			.assertThat()
			.statusCode(200);
	}

}
