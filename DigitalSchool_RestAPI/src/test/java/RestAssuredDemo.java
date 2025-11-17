

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;
 
public class RestAssuredDemo {
	
	Response response;
	String hostURL = "https://bookstore.toolsqa.com";
	
	
	//Account
	
	@Test
	void verifyAuthorization()
	{
		
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI=hostURL;
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("userName", "DeepakSGPD");
		requestParams.put("password", "Test@123");
		
		response = given()
				     //.baseUri(baseURI)
				     .header("Content-Type","application/json")
				     .body(requestParams.toString())
				   .when()
				     .post("Account/v1/Authorized")
				   .then()
				     .extract()
				     .response();
		response.prettyPrint();
	}
	
	

	
	@Test
	void generateToken()
	{
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI=hostURL;
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("userName", "DeepakSGPD");
		requestParams.put("password", "Test@123");
		
		response = given()
				.header("Content-Type","application/json")
				.body(requestParams.toString())
				//.log().all()
				.when()
				.post("/Account/v1/GenerateToken")
				.then()
				//.header("Content-Type","application/jso; charset=utf-8")
				//.time(lessThan(500L))
				.log().all()
				.extract().response();
		
		//response.prettyPrint();
//		int statusCode = response.getStatusCode();
//		System.out.println(statusCode);
		
		System.out.println();
		String  status = response.jsonPath().getString("status");
		String contentType = response.getHeader("Content-Type");
		Headers headers =response.getHeaders();
		
		List<Header> list = headers.asList();
		
		System.out.println(list);
		//System.out.println("Content Type is: " + contentType);
		//assertEquals(status, "Failed");
	}
	
	
	
	
	
	//af920169-4d80-4465-a50c-aab413cdb5ac  userID
	
	@Test
	void addUser()
	{
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI=hostURL;
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("userName", "DeepakSGPD");
		requestParams.put("password", "Test@123");
		
		response = given()
				.header("Content-Type","application/json")
				.body(requestParams.toString())
				.when()
				.post("/Account/v1/User")
				.then()
				.body("username", equalTo("DeepakSGPD"))
				.extract().response();
		
		response.prettyPrint();
		
		String userid = response.jsonPath().getString("userID");
		System.out.println("User ID is: " + userid);		
	}
	
	
	@Test
	void deleteUser()
	{
		
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI=hostURL;
		String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IkRlZXBha1NHUEQiLCJwYXNzd29yZCI6IlRlc3RAMTIzIiwiaWF0IjoxNzU4Njk5NjI2fQ.L3ZHcQZTWbEKI_PMRFEYV1PM5DD9WfA3lTO4KPj-7xw";
		
		response= 
				given()
				 .header("Authorization","Bearer "+token)
				 .pathParam("userid", "af920169-4d80-4465-a50c-aab413cdb5ac")
				.when()
				 .delete("/Account/v1/User/{userid}")
				.then()
				 .extract().response();
		
		response.prettyPrint();
		
	}
	
	
	
	
	
	
	
	
	@Test
	void getUserInfoUsingBasic()
	{
		
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI=hostURL;
		
		response= 
				given()
				 .auth().preemptive().basic("DeepakSGPD","Test@123")
				 .pathParam("userid", "ab25474c-5fbe-4f79-bf73-7701502bf077")
				.when()
				 .get("/Account/v1/User/{userid}")
				.then()
				 .extract().response();
		
		response.prettyPrint();
		
	}
	

	
	@Test
	void getUserInfo()
	{
		
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI=hostURL;
		String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IkRlZXBha1NHUEQiLCJwYXNzd29yZCI6IlRlc3RAMTIzIiwiaWF0IjoxNzU4Njk5NjI2fQ.L3ZHcQZTWbEKI_PMRFEYV1PM5DD9WfA3lTO4KPj-7xw";
		
//		response= given()
//				.header("Authorization","Bearer "+token)
//				.pathParam("userid", "ab25474c-5fbe-4f79-bf73-7701502bf077")
//				.when()
//				.get("/Account/v1/User/{userid}")
//				.then()
//				.extract().response();
		
 
		response= given()
				.auth()
				.basic("DeepakSGPD", "Test@123")
				.pathParam("userid", "ee0fbf9f-9109-4d33-891d-8df7e948f952")
				.when()
				.get("/Account/v1/User/{userid}")
				.then()
				.extract().response();
		
		response.prettyPrint();
		
	}
 

 
	
	
	//Books
	


	
	@Test
	void getBookList()
	{
		RestAssured.useRelaxedHTTPSValidation();
		//RestAssured.baseURI=baseURI;
		
		response = given()
				.baseUri(hostURL)
				.when()
				.get("/BookStore/v1/Books")
				.then()  // validate status code
				.statusCode(201)
				.extract().response();
		
	
		String responseBody = response.getBody().asString();
		//System.out.println(responseBody);
		response.prettyPrint();
	}
	
	@Test
	void addBook()
	{

		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI=hostURL;
				
		JSONObject requestParams = new JSONObject();
		requestParams.put("userId", "ab25474c-5fbe-4f79-bf73-7701502bf077");
		
		// Create the inner ISBN object
		JSONObject isbnObject = new JSONObject();
		isbnObject.put("isbn", "9781449337711");
		
		// Create the array and add the ISBN object
		JSONArray isbnArray = new JSONArray();
		isbnArray.put(isbnObject);
		
		// Add the array to the main object
		requestParams.put("collectionOfIsbns", isbnArray);
		
        String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IkRlZXBha1NHUEQiLCJwYXNzd29yZCI6IlRlc3RAMTIzIiwiaWF0IjoxNzU4Njk5NjI2fQ.L3ZHcQZTWbEKI_PMRFEYV1PM5DD9WfA3lTO4KPj-7xw";
		
		response = 
				given()
				//.baseUri(baseURI)
				  .header("Authorization","Bearer "+token)
                  .header("Content-Type", "application/json")
				  .body(requestParams.toString())
				.when()
				 .post("/BookStore/v1/Books")
				.then()  // validate status code
				 .extract().response();
				
		System.out.println("Response Body: " + response.getBody().asString());
		response.prettyPrint();


	}
	
	@Test
	void getBookUsingISBN()
	{
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI=hostURL;
		
        String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IkRlZXBha1NHUEQiLCJwYXNzd29yZCI6IlRlc3RAMTIzIiwiaWF0IjoxNzU4Njk5NjI2fQ.L3ZHcQZTWbEKI_PMRFEYV1PM5DD9WfA3lTO4KPj-7xw";
		
		response =
				given()
				//.baseUri(baseURI)
					.header("Authorization","Bearer "+token)
	                .header("Content-Type", "application/json")
	                .queryParam("ISBN", "9781449337711")
			    .when()
					.get("/BookStore/v1/Book")
				.then()  // validate status code
					.extract().response();
		
		response.prettyPrint();
	}
	
	

	@Test
	void putBookReplaceISBN()
	{
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI=hostURL;
		
        String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IkRlZXBha1NHUEQiLCJwYXNzd29yZCI6IlRlc3RAMTIzIiwiaWF0IjoxNzU4Njk5NjI2fQ.L3ZHcQZTWbEKI_PMRFEYV1PM5DD9WfA3lTO4KPj-7xw";
		
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("userId", "ab25474c-5fbe-4f79-bf73-7701502bf077");
		requestParams.put("isbn", "9781449331818");
        
		
        
		response =
				given()
				//.baseUri(baseURI)
					.header("Authorization","Bearer "+token)
	                .header("Content-Type", "application/json")
	                .pathParam("ISBN", "9781449337711")
	                .body(requestParams.toString())
			    .when()
					.put("/BookStore/v1/Books/{ISBN}")
				.then()  // validate status code
					.extract().response();
		
		response.prettyPrint();
	}
	
	
	
	
 
}
 
