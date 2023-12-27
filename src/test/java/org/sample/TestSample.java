package org.sample;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.Method;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestSample {
	
	@Test
	public void tc0() {
		//create a request object
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification requestSpecification = RestAssured.given();
		//add the query parameter
		requestSpecification.queryParam("page", "2");
		//create response object
		Response response = requestSpecification.request(Method.GET, "api/users");
		//to get the status code
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		//to print the response body
		String asString = response.getBody().asString();
		System.out.println(asString);
		
	}
	
	@Test //POST
	public void tc1() {
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification requestSpecification = RestAssured.given();
		//to attach the payload
		//jsonobject - object
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("name", "Raja rajan");
		jsonObject.put("job", "QA");
		requestSpecification.body(jsonObject.toJSONString());
		//create the response object
		Response response = requestSpecification.request(Method.POST, "/api/users");
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		String asString = response.getBody().asString();
		System.out.println(asString);
		
		
	}
	@Test //PUT
	public void tc2() {
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification requestSpecification = RestAssured.given();
		//to attach the payload
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("name", "Thameem");
		jsonObject.put("job", "QA Tester");
		requestSpecification.body(jsonObject.toJSONString());
		requestSpecification.pathParam("id", "2");
		Response response = requestSpecification.request(Method.PUT, "api/user/{id}");
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		String asString = response.getBody().asString();
		System.out.println(asString);
		
			
		}
}