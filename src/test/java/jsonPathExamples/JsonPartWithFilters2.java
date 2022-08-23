package jsonPathExamples;

import java.io.File;
import java.util.List;

import io.restassured.path.json.JsonPath;

public class JsonPartWithFilters2 {

	public static void main(String[] args) {
		
		//this time json array inside jason data

		String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\jsonPathExamples\\People2.json";	
		File jsonAarrayFile = new File(filePath);
		
		JsonPath js =  new JsonPath(jsonAarrayFile);
		
		System.out.println(js.getString("data[0].first_name"));//Ali
		
		
		//get all female names
		List<String> femaleFNs= js.getList("data.findAll{it.gender == 'female'}.first_name");
		System.out.println(femaleFNs); //[Sally, Asley, Linny, Fay]
		
		
	}

}
