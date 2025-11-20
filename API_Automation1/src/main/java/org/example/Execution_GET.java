package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;

public class Execution_GET extends BaseClass{

    public static void main(String[] args) throws IOException {
        initializeRequestSpecification();
        setBaseURI("https://826bfc08-7a0d-4c3f-ae82-b5bb6f6a7e6a.mock.pstmn.io");
        addHeader("Content-Type","application/json");
        String endPoint="issuing/customer/4501/Deepak";
        response = makeRequest(reqSpec,endPoint,"get");
        int statusCode = response.getStatusCode();
        System.out.println("Status code : "+statusCode);
        String body= response.getBody().asPrettyString();
        System.out.println("Body : "+body);

        //Using Object Mapper

        ObjectMapper mapper = new ObjectMapper() ;
        JsonNode root = mapper.readTree(response.asString());
        String cardNumber = root.path("identifiers").path("cardLast4").asText();

        System.out.println("Card number is :" +cardNumber);


    }
}
