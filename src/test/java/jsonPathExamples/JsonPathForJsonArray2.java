package jsonPathExamples;

import io.restassured.path.json.JsonPath;

public class JsonPathForJsonArray2 {
	
	public static void main(String[] args) {
		String jsonArray = "[\r\n"
				+ "  \"10\",\r\n"
				+ "  \"20\",\r\n"
				+ "  \"30\",\r\n"
				+ "  \"40\",\r\n"
				+ "  \"50\"\r\n"
				+ "]";
		//create jsonPath object
		
		JsonPath js = new JsonPath(jsonArray);
		System.out.println(js.getString("[2]"));
		System.out.println(js.getList("$"));//[10, 20, 30, 40, 50]
		System.out.println(js.getList("$").size());//5
		
		
	}
	
	

}
