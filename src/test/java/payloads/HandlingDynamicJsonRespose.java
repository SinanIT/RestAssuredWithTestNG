package payloads;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HandlingDynamicJsonRespose {

	public static void main(String[] args) {


//		Response response = RestAssured .get("https://run.mocky.io/v3/63dad712-94ac-4cbe-84f8-e60520cd36ee");
//		
//		Map responseAsMap= response.as(Map.class);
//		System.out.println(responseAsMap.keySet());//com.fasterxml.jackson.databind.exc.MismatchedInputException
												  //Cannot deserialize instance of `java.util.LinkedHashMap<java.lang.Object,java.lang.Object>` out of START_ARRAY token
		Response response = RestAssured.get("https://run.mocky.io/v3/7fabab7e-4c29-46ba-9e02-be7b7a989b17");
	
			List responseAsLsitList= response.as(List.class);
			System.out.println(responseAsLsitList);
			/*
			  com.fasterxml.jackson.databind.exc.MismatchedInputException: Cannot deserialize instance of `
			  java.util.ArrayList<java.lang.Object>` out of START_OBJECT token
			 */
			
		
			
			
	}

}
