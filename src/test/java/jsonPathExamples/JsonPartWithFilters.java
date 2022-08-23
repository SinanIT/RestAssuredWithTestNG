package jsonPathExamples;

import java.io.File;
import java.util.List;

import io.restassured.path.json.JsonPath;

public class JsonPartWithFilters {

	public static void main(String[] args) {

		String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\jsonPathExamples\\People.json";	
		File jsonAarrayFile = new File(filePath);
		
		JsonPath js =  new JsonPath(jsonAarrayFile);
		
		System.out.println(js.getString("[0].first_name"));//Ali
		
		//all the first names. If one of Json object don't have first_name it will return null
		List<String> allListFirstNames = js.getList("first_name");
		System.out.println(allListFirstNames);//[Ali, Sally, Corey, Cam, Sammy, Asley, Linny, Fay, Jonh, Fred]
		
		//get all female names
		List<String> femaleFNs= js.getList("findAll{it.gender == 'female'}.first_name");
		System.out.println(femaleFNs); //[Sally, Asley, Linny, Fay]
		
		//print specific email
		String email = js.getString("find{it.first_name == 'Asley' & it.last_name == 'Fry'}.email");
		System.out.println(email);//asley@gmail.com
		
		//print specific emails
		List<String> emails = js.getList("findAll{it.first_name == 'Asley' || it.last_name == 'Wick'}.email");
		System.out.println(emails);//[asley@gmail.com, john@gmail.com]
		
		//print all name s who is ID is grater then 5
		System.out.println(js.getList("findAll{it.id>=5}.first_name"));//[Sammy, Asley, Linny, Fay, Jonh, Fred]
		
		//find jason array size
		
		System.out.println(js.getInt("size()"));//10
	}

}
