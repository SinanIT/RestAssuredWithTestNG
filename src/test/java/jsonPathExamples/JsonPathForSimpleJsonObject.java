package jsonPathExamples;

import io.restassured.path.json.JsonPath;

public class JsonPathForSimpleJsonObject {
	
	public static void main(String[] args) {
	
	String jsonObject = "{\r\n"
			+ "  \"firstName\" : \"Sinan\",\r\n"
			+ "  \"lastName\" : \"Deger\",\r\n"
			+ "  \"age\" : 43,\r\n"
			+ "  \"address\" :{\r\n"
			+ "    \"flatNo\" : 102,\r\n"
			+ "    \"streetName\" : \"Creighton\",\r\n"
			+ "    \"zipCode\" : 27511,\r\n"
			+ "    \"city\" :  \"Cary\",\r\n"
			+ "    \"state\" : \"NC\"\r\n"
			+ "  },\r\n"
			+ "  \"salary\" : 4500.50,\r\n"
			+ "  \"married\" : true\r\n"
			+ "}";
	
	//simple json object
	JsonPath jsonPath = new JsonPath(jsonObject);
	String fname =  jsonPath.getString("firstName");
	System.out.println(fname);
	int age = jsonPath.getInt("age");
	System.out.println(age);
	boolean isMarried = jsonPath.getBoolean("married");
	System.out.println(isMarried);
	float salary = jsonPath.getFloat("salary");
	System.out.println(salary);
	
	//nested json object
	Object addressObject = jsonPath.get("address");
	System.out.println(addressObject);//{flatNo=102, streetName=Creighton, zipCode=27511, city=Cary, state=NC}
	
	int flatNo = jsonPath.getInt("address.flatNo");
	System.out.println(flatNo);//102
	int zip = jsonPath.getInt("address.zipCode");
	System.out.println(zip);//27511
	
}
}
