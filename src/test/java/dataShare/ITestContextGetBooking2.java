package dataShare;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ITestContextGetBooking2 {
	
	
	
	@Test(priority = 2)
	public void retreieveBooking(ITestContext context) {
		Response response = 
				RestAssured
				.given()
				.log()
				.all()
				.get("https://restful-booker.herokuapp.com/booking/" + context.getSuite().getAttribute("bookingid"))
				.then()
				.log()
				.all()
				.extract()
				.response();
	}

}
