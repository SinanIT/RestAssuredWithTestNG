package payloads;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HandlingDynamicJsonResposeUsingInstanceOf {

	public static void main(String[] args) {

//		Response response = RestAssured.get("https://run.mocky.io/v3/7fabab7e-4c29-46ba-9e02-be7b7a989b17");
//	
//			Object responseAsObject = response.as(Object.class);
//			if (responseAsObject instanceof List) 
//			{
//				List responseAsList = (List) responseAsObject;
//				System.out.println(responseAsList.size());
//			}else if (responseAsObject instanceof Map) {
//				Map responseAsMap = (Map)responseAsObject;
//				System.out.println(responseAsMap.keySet());//[accountNo, balance, first_name, last_name, email, gender]
//				
//			}
			
			
			Response response = RestAssured.get("https://run.mocky.io/v3/63dad712-94ac-4cbe-84f8-e60520cd36ee");
			
			Object responseAsObject = response.as(Object.class);
			if (responseAsObject instanceof List) 
			{
				List responseAsList = (List) responseAsObject;
				System.out.println(responseAsList.size());   // ==> 2
			}else if (responseAsObject instanceof Map) {
				Map responseAsMap = (Map)responseAsObject;
				System.out.println(responseAsMap.keySet());

				
			}
			
			
			
			
			
			
			

	}

}
