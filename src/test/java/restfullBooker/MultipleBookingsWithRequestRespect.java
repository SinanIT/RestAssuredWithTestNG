package restfullBooker;


import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class MultipleBookingsWithRequestRespect {

	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	
	@BeforeClass
	public void setUpRequestSpec() {
		requestSpecification = RestAssured.given()
				.log()
				.all()
				.baseUri("https://restful-booker.herokuapp.com")
				.contentType(ContentType.JSON);
		
		responseSpecification = RestAssured
				.expect().statusCode(200)
				.contentType(ContentType.JSON)
				.time(Matchers.lessThan(5000L));
	}
	
		@Test
		public void createBookin1() {
			RestAssured
			.given()
			.spec(requestSpecification)
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
			//hit the request and get the response
			.post()
			//Validate Response
			.then()
			.log()
			.all()
			.spec(responseSpecification);
			

	}
		
		@Test
		public void updateBooking() {
			RestAssured
			.given()
			.spec(requestSpecification)
			.basePath("booking/1133")
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
				.spec(responseSpecification);
		}

}
