package test;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class gitActivity {

	RequestSpecification reqSpec;

	int key;
	String sshKey;

	@Test(priority = 1)
	public void postSSH() {
		String requestBody = "{\"title\": \"TestKey\", \"key\": \"" + sshKey + "\" }";

		Response response = given().spec(reqSpec).body(requestBody).when().post("/user/keys");

		String RespBody = response.getBody().asPrettyString();
		System.out.println(RespBody);
		key = response.then().extract().path("id");

	}

	@Test(priority = 2)

	public void getSSHKeys() {
		Response response = given().spec(reqSpec).when().get("/user/keys");
		String resBody = response.getBody().asPrettyString();
		System.out.println(resBody);
		response.then().statusCode(200);
	}

	@Test(priority = 3)

	public void deleteSShKeys() {
		Response response = given().spec(reqSpec).pathParam("keyId", key).when().delete("/user/keys/{keyId}");
		String resBody = response.getBody().asPrettyString();
		System.out.println(resBody);
		// Assertions
		response.then().statusCode(204);
	}

	@BeforeClass
	public void setUp() {
		reqSpec = new RequestSpecBuilder().setContentType(ContentType.JSON)
				.addHeader("Authorization", "token 00")
				.setBaseUri("https://api.github.com").build();

		sshKey = "ssh-rsa ";
	}

}
