package Activities;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileWriter;
import java.io.IOException;

public class Activity2 {
	String BASE_URL = "https://petstore.swagger.io/v2/user";

  @Test(priority = '0')
  public void postReq() throws IOException {
	  
	  FileInputStream JSON_File = new FileInputStream("C:\\Users\\VineetArora\\Module2_Sdet\\SampleRestAssured\\src\\Outputs\\request.json");
	  String reqBody = new String(JSON_File.readAllBytes());
	  
  
  Response response = given().contentType(ContentType.JSON).body(reqBody).when().post(BASE_URL);
  
  //Assert
  System.out.println(response.asPrettyString());
  JSON_File.close();
  
  response.then().body("code", equalTo(200));
  response.then().body("message", equalTo("9001"));
}
  
  @Test (priority = '1')
  public void getReq() {
	  
		File JSON_File = new File("C:\\Users\\VineetArora\\Module2_Sdet\\SampleRestAssured\\src\\Outputs\\response.json");
	  
  
  Response response = given().contentType(ContentType.JSON).when().get(BASE_URL+"/vineet1");
  
  String resBody = response.asPrettyString();
  
  //Save to external file
  try {
		
      // Create log file
	
	
      JSON_File.createNewFile();
	
      // Write response body to external file
	
      FileWriter writer = new FileWriter(JSON_File.getPath());
	
      writer.write(resBody);
	
      writer.close();
	
  } catch (IOException excp) {
	
      excp.printStackTrace();
	
  }
  
  System.out.println(resBody);
  
  // Assertion
  response.then().body("id", equalTo(9001));
  response.then().body("username", equalTo("vineet1"));
  response.then().body("firstName", equalTo("Justin"));
	
}



@Test(priority = '2')
	public void deleteReq() {

		Response response = given().contentType(ContentType.JSON).when().pathParam("username", "vineet1")
				.delete(BASE_URL + "/{username}");
		// Assertion

		  System.out.println(response.asPrettyString());
		response.then().body("code", equalTo(200));

		response.then().body("message", equalTo("vineet1"));
	}

}
