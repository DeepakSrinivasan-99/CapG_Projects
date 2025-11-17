package com.practice.rahulshetty;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;

import files.ReUsableMethods;
import files.payload;



public class Basics {

	
	public static void main(String[] args) throws IOException {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		RestAssured.useRelaxedHTTPSValidation();
		
		//POST(Create Data)
		
	/*	String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
        .body(payload.AddPlace()).when().post("maps/api/place/add/json")
        .then().assertThat().log().all().statusCode(200).body("scope", equalTo("APP"))
        .header("server","Apache/2.4.52 (Ubuntu)").extract().response().asString();	    */
		
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		        .body(new String(Files.readAllBytes(Paths.get("C:\\Users\\sdeepak1\\Desktop\\Deepak\\API_Automation_Session\\RahulShetty Course _RestAPI\\Test_Data\\POST_GMAP_API.json"))))
		        .when().post("maps/api/place/add/json")
		        .then().assertThat().log().all().statusCode(200).body("scope", equalTo("APP")).body("status", equalTo("OK"))
		        .header("server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		System.out.println("Response in String :\n"+response);
		
		JsonPath js = new JsonPath(response);  //parsing response
		
		String place_id= js.getString("place_id");
		System.out.println("PlaceID after POST :\n"+place_id);
		
		
		//PUT(Update)
		
		String newAddress = "70 Summer walk, USA";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+place_id+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "")
		.when().put("maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg",equalTo("Address successfully updated"));
		
		
		//Get
		
		String getPlaceResponse=given().log().all().queryParam("key", "qaclick123").queryParam("place_id", place_id)
		.when().get("maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
	
		
		JsonPath js1 = ReUsableMethods.rawToJson(getPlaceResponse);
		String actualAddress = js1.getString("address");
		System.out.println(actualAddress);
		
		Assert.assertEquals(actualAddress, newAddress);
	
	
	}
	
	
	
	

}
