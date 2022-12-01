import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class TC_004_GET_REQUEST3 {

	@Test
	public void singleUserRestTest() {

		RestAssured.baseURI = "https://reqres.in/";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.get("/api/users/1");

		ResponseBody<?> body = response.getBody();
		String bodyAsString = body.asPrettyString();
		System.out.println(bodyAsString);
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		Assert.assertEquals(bodyAsString.contains("George"), true);
		Assert.assertEquals(bodyAsString.contains("https://reqres.in/img/faces/1-image.jpg"), true);
		
	}

}
