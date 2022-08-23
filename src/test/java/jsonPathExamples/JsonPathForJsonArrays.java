package jsonPathExamples;

import io.restassured.path.json.JsonPath;

public class JsonPathForJsonArrays {
	
	public static void main(String[] args) {
		
		String jsonArray = "[\r\n"
				+ "{\r\n"
				+ "  \"firstName\" : \"Sinan\",\r\n"
				+ "  \"lastName\" : \"Deger\",\r\n"
				+ "  \"age\" : 43,\r\n"
				+ "  \"address\" : [\r\n"
				+ "  {\r\n"
				+ "    \"flatNo\" : 102,\r\n"
				+ "    \"streetName\" : \"Creighton\",\r\n"
				+ "    \"zipCode\" : 27511,\r\n"
				+ "    \"city\" :  \"Cary\",\r\n"
				+ "    \"state\" : \"NC\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"city\" :  \"Newyork\",\r\n"
				+ "    \"state\" : \"NY\"\r\n"
				+ "  }\r\n"
				+ "  ],\r\n"
				+ "  \"salary\" : 4500.50,\r\n"
				+ "  \"maried\" : true\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "  \"firstName\" : \"Sam\",\r\n"
				+ "  \"lastName\" : \"Sammy\",\r\n"
				+ "  \"age\" : 50,\r\n"
				+ "  \"address\" : [\r\n"
				+ "  {\r\n"
				+ "    \"flatNo\" : 105,\r\n"
				+ "    \"streetName\" : \"Creighton\",\r\n"
				+ "    \"zipCode\" : 27513,\r\n"
				+ "    \"city\" :  \"Denver\",\r\n"
				+ "    \"state\" : \"NC\"\r\n"
				+ "  },\r\n"
				+ "    {\r\n"
				+ "    \"flatNo\" : 205,\r\n"
				+ "    \"streetName\" : \"culver\",\r\n"
				+ "    \"zipCode\" : 91300,\r\n"
				+ "    \"city\" :  \"LA\",\r\n"
				+ "    \"state\" : \"CA\"\r\n"
				+ "  }\r\n"
				+ "  ],\r\n"
				+ "  \"salary\" : 4500.50,\r\n"
				+ "  \"maried\" : true,\r\n"
				+ "  \"mobile\" : 45678925\r\n"
				+ "}\r\n"
				+ "]";
		
		JsonPath js = new JsonPath(jsonArray);
		
		//get city Cary
		
		String city1 = js.getString("[0].address[0].city");
		System.out.println(city1);//Cary
		
		String city2 = js.getString("[1].address[1].city");
		System.out.println(city2);//LA
		
		System.out.println(js.getList("[0].address.city"));//[Cary, Newyork]  city list
		
		System.out.println(js.getList("address.city"));//[[Cary, Newyork], [Denver, LA]] All city list
		
		System.out.println(js.getList("address"));
		/*
		 * [[{flatNo=102, streetName=Creighton, zipCode=27511, city=Cary, state=NC}, {city=Newyork, state=NY}], 
		 * [{flatNo=105, streetName=Creighton, zipCode=27513, city=Denver, state=NC}, {flatNo=205, streetName=culver, zipCode=91300, city=LA, state=CA}]]

		 */
	}

}
