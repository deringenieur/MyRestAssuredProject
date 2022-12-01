import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_002_POST_REQUEST {

	@Test
	void RegistrationCustomerValidation() {

		RestAssured.baseURI = "http://restapi.demoqa.com/customer";

		RequestSpecification httpRequest = RestAssured.given();

		JSONObject requestParams = new JSONObject();

		requestParams.put("FirstName", "Furkan");
		requestParams.put("LastName", "Guler");
		requestParams.put("userName", "frkn");
		requestParams.put("Password", "xyz");
		requestParams.put("Email", "frkn@gmail.com");

		httpRequest.header("Content-Type", "application/json");

		httpRequest.body(requestParams.toJSONString());

		Response response = httpRequest.request(Method.POST, "/register");

		String responseBody = response.getBody().asString();
		System.out.println(responseBody);

		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 201);

		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals(successCode, "OPERATION_SUCCESS");

	}

}
