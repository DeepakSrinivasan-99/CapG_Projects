package org.example;

public class Execution_POST extends BaseClass{

    public static void main(String[] args) {
        initializeRequestSpecification();
        setBaseURI("https://826bfc08-7a0d-4c3f-ae82-b5bb6f6a7e6a.mock.pstmn.io");
        addHeader("Content-Type","application/json");
        addBody("{\n" +
                "    \"name\" : \"Deepak\",\n" +
                "    \"Address\":[\n" +
                "        { \"No\": \"11/197\"},\n" +
                "        {\"Street\": \"Balakrishnapuram\"\n" +
                "        },\n" +
                "        {\"City\": \"Chennai\"\n" +
                "        }\n" +
                "    ]\n" +
                "}");
        String endPoint="/issuing/customer/4501/addAddress";
        response = makeRequest(reqSpec,endPoint,"post");
        int statusCode = response.getStatusCode();
        System.out.println("Status code : "+statusCode);
        String body= response.getBody().asPrettyString();
        System.out.println("Body : "+body);

    }
}
