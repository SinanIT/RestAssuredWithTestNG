package restfullBooker;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class MeasureResponseTime {
	public static void main(String[] args) {
		Response response =
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
		.post();
		
		long responseTimeinMS= response.time();
		System.out.println("Response time in MS: "+responseTimeinMS);
		
		long responseTimeinSeconds =  response.timeIn(TimeUnit.SECONDS);
		System.out.println("Response time in Second: "+responseTimeinSeconds);
		
		long responseGetTimeMS= response.getTime();
		System.out.println("Response getTime in MS: "+responseGetTimeMS);
		
		long responseGetTimeinSeconds =  response.getTimeIn(TimeUnit.SECONDS);
		System.out.println("response GetTimeIn Second: "+responseGetTimeinSeconds);
		
		response.then().time(Matchers.both(Matchers.greaterThan(1000L)).and(Matchers.lessThan(3000L)));
		//response.then().time(Matchers.greaterThan(1000L));
		
	}

}
