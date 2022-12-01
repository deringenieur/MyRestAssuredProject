

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.proxy;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class TC_006_GET_REQUEST {
	
public RequestSpecification getCommonSpec() {
		
		RequestSpecBuilder builder = new RequestSpecBuilder();
		
		builder.addHeader("MyHeader", "Something");
		builder.addCookie("Key", "value");
		builder.setAccept(ContentType.ANY);
		RequestSpecification requestSpec = builder.build();
		return requestSpec;
		
	}
	
	@Test
	public void specificationExample() {
		
	
		proxy(8888);
		RequestSpecification requestSpec = getCommonSpec();
		
		given().
		         spec(requestSpec).
		         param("parameter2", "paramValue").
		when().
		         get("/something").
	    then().
	             body("x.y.z", equalTo("something"));
		
		
	}

}
