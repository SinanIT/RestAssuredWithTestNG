package restfullBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ExtractResponseAsString {
	public static void main(String[] args) {
		
		//build request
		
		String responseBody =
		
		RestAssured
		.given()
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
		
		.post()
		.then()
		
		//response in string
		.extract()
		.body()
		.asPrettyString();
		
		System.out.println(responseBody);
	}
}
