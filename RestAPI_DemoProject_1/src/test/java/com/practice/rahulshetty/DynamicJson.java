package com.practice.rahulshetty;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.ReUsableMethods;
import files.payload;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DynamicJson {

	@Test(dataProvider="BooksData")
	public void addBook(String isbn,String aisle)
	{
		//RestAssured.baseURI="http://216.10.245.166";  
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		RestAssured.useRelaxedHTTPSValidation();

		Response response= given().log().all().header("Content-Type","application/json")
		.body(payload.AddBook(isbn,aisle))
		
		.when()
		.post("Library/Addbook.php")
		
		.then().log().all().assertThat().statusCode(200)
		.extract().response();
		
		JsonPath js= ReUsableMethods.rawToJson(response.asString());
		
		String id = js.get("ID");
		
		System.out.println(id);
		
		//PrettyString
		
		System.out.println("\n\nResponse JSON is : "+response.asPrettyString());
		
	}
	
	//array - collection of elements ; MultiDimensional Array - collection of arrays.
	//Passing multiple sets of data
	@DataProvider(name="BooksData")
	public Object[][] getData()
	{
		return new Object[][] {{"fdyeh","9382"},{"jqfrj","7847"},{"ftrvh","8432"}};
	}
	
	
}
