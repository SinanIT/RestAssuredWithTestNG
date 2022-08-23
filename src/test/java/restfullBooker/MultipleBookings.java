package restfullBooker;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class MultipleBookings {

		
		@Test
		public void createBookin1() {
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
			.statusCode(200);

	}
		
		@Test
		public void updateBooking() {
			RestAssured
			.given()
				.log()
				.all()
				.baseUri("https://restful-booker.herokuapp.com/")
				.basePath("booking/2020")
				.header("Content-Type", "application/json")
				.header("authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
				.body("{\r\n"
					+ "    \"firstname\" : \"Sam\",\r\n"
					+ "    \"lastname\" : \"White\",\r\n"
					+ "    \"totalprice\" : 111,\r\n"
					+ "    \"depositpaid\" : true,\r\n"
					+ "    \"bookingdates\" : {\r\n"
					+ "        \"checkin\" : \"2018-01-01\",\r\n"
					+ "        \"checkout\" : \"2019-01-01\"\r\n"
					+ "    },\r\n"
					+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
					+ "}")
			.when()
				.put()
			.then()
				.log()
				.all()
				.assertThat().statusCode(200); 
		}

}
