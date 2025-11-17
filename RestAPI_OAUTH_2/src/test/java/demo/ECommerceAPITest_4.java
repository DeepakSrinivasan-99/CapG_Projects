package demo;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import pojo.LoginRequest;
import pojo.LoginResponse;
import pojo.OrderDetail;
import pojo.Orders;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import io.restassured.RestAssured;

public class ECommerceAPITest_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.useRelaxedHTTPSValidation();

		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
		
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setUserEmail("testergpd@gmail.com");
		loginRequest.setUserPassword("Tester@123");
		
		//https://rahulshettyacademy.com/client/#/auth/login
		
		RequestSpecification reqLogin = given().log().all().spec(req).body(loginRequest);  //POJO to JSON payload in body (serialization)
		

		
		LoginResponse loginResponse =  reqLogin.when().post("/api/ecom/auth/login").then().log().all().extract().response().as(LoginResponse.class);  //(JSON to POJO class (Deserialization)
		
		String token = loginResponse.getToken();
        System.out.println(loginResponse.getToken());	
        
        String userId = loginResponse.getUserId();
        System.out.println(loginResponse.getUserId());
        
        
       //Add product
        
        RequestSpecification addProductBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
        		.addHeader("Authorization", token)
        		.build();
        
       RequestSpecification reqAddProduct = given().log().all().spec(addProductBaseReq)
        .param("productName", "Laptop").param("productAddedBy",userId).param("productCategory","fashion")
        .param("productSubCategory", "shirts").param("productPrice", "11500")
        .param("productDescription", "Lenova").param("productFor","men")
        .multiPart("productImage",new File("C:\\Users\\sdeepak1\\Desktop\\Deepak\\API_Automation_Session\\RahulShetty Course _RestAPI\\Test_Data\\photos_PostOrder.jpg"));
        
       String addProductResponse = reqAddProduct.when().post("api/ecom/product/add-product")
        .then().log().all().extract().response().asString();
       
        
	  JsonPath js= new JsonPath(addProductResponse);
	  
	  String productId = js.getString("productId");
	  
	  //Create Order
	  
	 RequestSpecification createOrderBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
			 .addHeader("Authorization", token).setContentType(ContentType.JSON)
			 .build();
	 
	 OrderDetail orderDetail = new OrderDetail();
	 orderDetail.setCountry("India");
	 orderDetail.setProductOrderedId(productId);
	 
	 List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
	 orderDetailList.add(orderDetail);
	 
	 Orders orders = new Orders();
	 orders.setOrders(orderDetailList);
	 
	 RequestSpecification createOrderReq = given().log().all().spec(createOrderBaseReq).body(orders);
	 
	String responseAddOrder = createOrderReq.when().post("/api/ecom/order/create-order").then().log().all().extract().response().asPrettyString();
	
	System.out.println("\n The response for Add Order : \n"+responseAddOrder);
	
	//View Order Details
	
	JsonPath js3 = new JsonPath(responseAddOrder);
	String orderID =js3.getString("orders[0]");
	System.out.println("\nThe OrderID is : "+orderID);
	
	RequestSpecification viewOrderBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
			.addHeader("Authorization", token)
			.setContentType(ContentType.JSON)
			.build();
	
	
	 RequestSpecification  viewOrderReq = given().log().all().spec(viewOrderBaseReq).queryParam("id", orderID);
	 
	 String responseViewOrder = viewOrderReq.when().get("api/ecom/order/get-orders-details")
			 .then().log().all().extract().asString();
	 
	 JsonPath js4 = new JsonPath(responseViewOrder);
	String orderIDResponse= js4.getString("data._id");
	System.out.println("Order ID through View Order Details :"+orderIDResponse);
	 
	
	//Delete Product
	
	RequestSpecification deleteProdBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
			.addHeader("Authorization", token).setContentType(ContentType.JSON)
			.build();
	
	RequestSpecification  deleteProdReq = given().log().all().spec(deleteProdBaseReq).pathParam("productId", productId);
	
	String deleteProductResponse = deleteProdReq.when().delete("/api/ecom/product/delete-product/{productId}").then().log().all()
			.extract().response().asString();
	JsonPath js1 = new JsonPath(deleteProductResponse);
	Assert.assertEquals("Product Deleted Successfully", js1.get("message"));
	  
	}

}
