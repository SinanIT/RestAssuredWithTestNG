package restfullBooker;


import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class WithDefaultValues2 {

	@Test
	public void createBooking1() {
		
		RestAssured
		.given()
		.basePath("auth")
		.body("{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
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
