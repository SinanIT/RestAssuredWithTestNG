package jsonPathExamples;

import java.util.List;

import io.restassured.path.json.JsonPath;

public class JsonPathForJsonArray {
	
	public static void main(String[] args) {
		String jsonArray = "[\r\n"
				+ "  [\r\n"
				+ "  \"10\",\r\n"
				+ "  \"20\",\r\n"
				+ "  \"30\",\r\n"
				+ "  \"40\",\r\n"
				+ "  \"50\"\r\n"
				+ "  ],\r\n"
				+ "  [\r\n"
				+ "  \"100\",\r\n"
				+ "  \"200\",\r\n"
				+ "  \"300\",\r\n"
				+ "  \"400\",\r\n"
				+ "  \"500\",\r\n"
				+ "  \"600\"\r\n"
				+ "  ]\r\n"
				+ "]";
		//create jsonPath object
		
		JsonPath js = new JsonPath(jsonArray);
		System.out.println(js.getString("[1][2]"));
		System.out.println(js.getList("$"));//[[10, 20, 30, 40, 50], [100, 200, 300, 400, 500]]

		//find internal array size
		List<Object> internalList = (List<Object>)js.getList("$").get(0);
		System.out.println(internalList.size());//5
		
		
	}
	
	

}
