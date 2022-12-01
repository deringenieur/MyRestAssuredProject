import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_003_GET_REQUEST {
	
	@Test
	void googleMapTest() {

		RestAssured.baseURI = "https://maps.googleapis.com";

		// Request object creation
		RequestSpecification httpRequest = RestAssured.given();

		// Response object creation
		Response response = httpRequest.request(Method.GET, "/Poznan");

		// JSON to string transformation
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);

		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200);

		// Status line verification
		String statusLine = response.getStatusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}

}
