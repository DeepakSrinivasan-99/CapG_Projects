package files;

import io.restassured.path.json.JsonPath;

public class ReUsableMethods {

	
		// TODO Auto-generated method stub
public static JsonPath rawToJson(String response)
{
	JsonPath js = new JsonPath(response);
	return js;
}
		


}
