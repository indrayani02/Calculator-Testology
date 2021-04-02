package Policies;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
//import static org.hamcrest.Matcher.*;



public class policycheck {
	
	@Test
	public void getpolicies()
	{
		given()
		       .baseUri("https://console-staging.flexiloans.com").
		when()
		       .get("/policy/check-policies/60261ae7zrad3").
		then()
		       .statusCode(200);
	}
 
}
