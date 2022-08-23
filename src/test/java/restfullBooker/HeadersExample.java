package restfullBooker;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;

public class HeadersExample {
	
	//PASSING HEADERS
	
	
	@Test
	public void passHeader() {
		RestAssured
		.given()
		.log()
		.all()
		.header("header 1", "value 1")
		.header("header 2", "value 1", "value 2", "value 3")
		.when()
		.get();
	}
	
	@Test
	public void passHeader1() {
		RestAssured
		.given()
		.log()
		.all()
		.header("header 1", "value 1")
		.header("header 1", "value 2")
		.when()
		.get();
	}
	
	@Test
	public void passHeader2() {
		
		Header header = new Header("Header1", "Value1");
		
		RestAssured
		.given()
		.log()
		.all()
		.header(header)
		.when()
		.get();
	}
	
	@Test
	public void passHeader3() {
		
		//Header header = new Header("Header1", "Value1");
		
		RestAssured
		.given()
		.log()
		.all()
		.headers("h1","v1","h2","h2","h3","v3","h3","v4")
		.when()
		.get();
	}
	
	@Test
	public void passHeader4() {
		
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("h1","v1");
		headerMap.put("h2","v2");
		headerMap.put("h3","v3");
		headerMap.put("h4","v4");
	
		RestAssured
		.given()
		.log()
		.all()
		.headers(headerMap)
		.when()
		.get();
	}

}
