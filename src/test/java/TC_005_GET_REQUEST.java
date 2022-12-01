
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

public class TC_005_GET_REQUEST {

	@Test
	public void simpleTest() {

		given().pathParam("methodName", "get").

				when().
				get("http://www.postman-echo.com/{methodName}").
				then().
				assertThat()
				.body("headers.host", equalTo("www.postman-echo.com"))
				.body("headers.accept-encoding", equalTo("gzip,deflate"))
				.body("headers.x-forwarded-port", equalTo("80"))
				.body("url", equalTo("http://www.postman-echo.com/get")).
				assertThat().statusCode(HttpStatus.SC_OK);

	}

	@Test
	public void getMovieAndActorNames() {

				given().
				when().get("https://swapi.dev/api/films").
				then().
				assertThat().body("results.title[0]", equalTo("A New Hope"))
				.body("results.title", everyItem(notNullValue()))
				.body("results.size()", greaterThan(0)).
				assertThat().statusCode(HttpStatus.SC_OK).
				extract().htmlPath().get("html.body");

	}
}
