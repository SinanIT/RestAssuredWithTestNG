package payloads;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class ConvertJsonArrayResposeToList {

	public static void main(String[] args) {
		
		List<Map<String, Object>> allEmp = RestAssured
		.get("https://run.mocky.io/v3/ec4f5536-a947-4f64-a7a5-272685436c3b")
		//.as(List.class);//or
		.as(new TypeRef<List<Map<String, Object>>>(){});
		
		
		System.out.println(allEmp.size());
		
		//System.out.println(allEmp);//[{id=1, first_name=Claire, last_name=Dennerley, email=cdennerley0@uol.com.br, gender=Male}, {id=2, first_name=Cloe, last_name=Stuehmeyer, email=cstuehmeyer1@yellowpages.com, gender=Female}]
		//Map<String, Object> emp1 = (Map<String, Object>) allEmp.get(0);
		//System.out.println(emp1.get("first_name"));
		
		
		Map<String, Object> employe1 = allEmp.get(0);
		System.out.println(employe1.get("first_name"));

	}

}
