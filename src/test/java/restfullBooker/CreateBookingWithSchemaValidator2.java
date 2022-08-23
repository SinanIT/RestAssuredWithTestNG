package restfullBooker;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class CreateBookingWithSchemaValidator2 {
	public static void main(String[] args) {
		

		RestAssured
		.given()
		.log()
		.all()
		.baseUri("https://restful-booker.herokuapp.com")
		.basePath("booking")
		.body("{\r\n"
				+ "    \"firstname\": \"Sam\",\r\n"
				+ "    \"lastname\": \"Brown\",\r\n"
				+ "    \"totalprice\": 111,\r\n"
				+ "    \"depositpaid\": true,\r\n"
				+ "    \"bookingdates\": {\r\n"
				+ "        \"checkin\": \"2018-01-01\",\r\n"
				+ "        \"checkout\": \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\": \"Breakfast\"\r\n"
				+ "}")
		.contentType(ContentType.JSON)
		//hit the request and get the response
		.post()
		//Validate Response
		.then()
		.log()
		.all()
		.statusCode(200)
		.body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\sinan\\OneDrive\\EclipsProjects\\"
				+ "RestAssuredWithTestNG\\src\\test\\java\\restfullBooker\\CreateBookingResponseSchema1.json")));

	}

}
