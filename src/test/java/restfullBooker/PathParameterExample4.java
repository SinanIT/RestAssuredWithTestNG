package restfullBooker;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;

public class PathParameterExample4 {
	
	public static void main(String[] args) {
		
		Map<String, Object> pathParametersMap = new HashMap<>();
		pathParametersMap.put("basePath", "booking");
		pathParametersMap.put("bookingId", "1659");
		
		RestAssured
		.given()
			.log()
			.all()
			.baseUri("https://restful-booker.herokuapp.com/")
			.basePath("{basePath}/{bookingId}")
			.pathParams(pathParametersMap)
		.when()
			.get()
		.then()
			.log()
			.all()
			.statusCode(200);
	}

}
