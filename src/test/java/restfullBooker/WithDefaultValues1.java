package restfullBooker;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class WithDefaultValues1 {

	@BeforeTest
	public void setUp() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		RestAssured.basePath = "booking";
	}
	
	@Test
	public void createBooking1() {
		
		RestAssured
		.given()
		.log()
		.all()
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
	public void createBooking2() {
		
		RestAssured
		.given()
		.log()
		.all()
		.body("{\r\n"
				+ "    \"firstname\": \"Sammy\",\r\n"
				+ "    \"lastname\": \"White\",\r\n"
				+ "    \"totalprice\": 1141,\r\n"
				+ "    \"depositpaid\": true,\r\n"
				+ "    \"bookingdates\": {\r\n"
				+ "        \"checkin\": \"2018-01-01\",\r\n"
				+ "        \"checkout\": \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\": \"Lunch\"\r\n"
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

}
