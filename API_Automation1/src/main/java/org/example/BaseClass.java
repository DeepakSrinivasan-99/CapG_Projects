package org.example;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

    public static RequestSpecification reqSpec;

    public static Response response;

    public static void initializeRequestSpecification(){
        reqSpec= new RequestSpecBuilder().build();
    }

    public static RequestSpecification setBaseURI(String URI){

       return reqSpec= RestAssured.given().baseUri(URI).relaxedHTTPSValidation();
    }

    public static RequestSpecification addProxy(String Proxy) {
      return reqSpec.proxy(Proxy);
    }

    public static RequestSpecification addCookie(String cookieName,String value) {
        return reqSpec.cookie(cookieName,value);
    }

    public static void addHeader(String HeaderName,String HeaderValue){
        reqSpec.header(HeaderName,HeaderValue);
    }

    public static void addPathParam(String pathName,String pathValue){
        reqSpec.pathParam(pathName,pathValue);
    }

    public static void addQueryParam(String queryName,String queryValue){
        reqSpec.queryParam(queryName,queryValue);
    }

    public static void addBody(String body){
        reqSpec.body(body);
    }

    public static Response makeRequest(RequestSpecification reqSpec,String endPoint,String type){
        try{
            switch(type.toUpperCase())
            {
                case "GET":
                    return reqSpec.log().all().get(endPoint);

                case "POST":
                    return reqSpec.log().all().post(endPoint);
                case "PUT":
                    return reqSpec.log().all().put(endPoint);
                default:
                    throw new IllegalArgumentException("Invalid Request Type");
            }
        }
        catch(Exception e)
        {
            throw new RuntimeException("Failed to Send Request");
        }
    }








}
