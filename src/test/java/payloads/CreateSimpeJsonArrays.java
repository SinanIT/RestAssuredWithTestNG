package payloads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;

public class CreateSimpeJsonArrays {

	public static void main(String[] args) {
		
		
		Map<String, Object> empDetails = new HashMap<>();
		empDetails.put("id", 1);
		empDetails.put("first_name", "Cirstoforo");
		empDetails.put("last_name", "Legerwood");
		empDetails.put("email", "clegerwood0@paginegialle.it");
		empDetails.put("gender", "Male");
		
		Map<String, Object> empDetails2 = new HashMap<>();
		empDetails2.put("id", 2);
		empDetails2.put("first_name", "Maurizia");
		empDetails2.put("last_name", "Fletham");
		empDetails2.put("email", "mfletham1@wsj.com");
		empDetails2.put("gender", "Female");
		
		List<Map<String, Object>> allEmployies = new ArrayList<>();
		allEmployies.add(empDetails);
		allEmployies.add(empDetails2);
		
		RestAssured
		.given()
		.log()
		.all()//[{"gender":"Male","last_name":"Legerwood","id":1,"first_name":"Cirstoforo","email":"clegerwood0@paginegialle.it"},
			//   {"gender":"Female","last_name":"Fletham","id":2,"first_name":"Maurizia","email":"mfletham1@wsj.com"}]

		.body(allEmployies)
		.get();
		

	}

}
