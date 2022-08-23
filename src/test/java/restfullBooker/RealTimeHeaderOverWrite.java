package restfullBooker;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class RealTimeHeaderOverWrite {
	
	@Test
	public void realTimeHeaderOverWrite() {
		
		RequestSpecification spec1 = RestAssured.given()
				.header("header1", "value1");
		RequestSpecification spec2 = RestAssured.given()
				.header("header2", "value2");
		
		RestAssured.given()
		.spec(spec1)
		.spec(spec2)
		.log()
		.all()
		.when()
		.get();
	}

}
