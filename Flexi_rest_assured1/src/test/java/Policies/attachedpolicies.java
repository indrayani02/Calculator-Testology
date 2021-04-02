package Policies;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
//import io.restassured.response.Response;
//import java.util.regex.Matcher;
import org.testng.annotations.Test;
//import io.restassured.response.Response;
//import io.restassured.matcher.ResponseAwareMatcher;


public class attachedpolicies 
{
  @Test
  public void attachedpolicy() 
  {
	  
	  given()
	  
	  .baseUri("https://console-staging.flexiloans.com").
	  when()
	  .get("/policy/attached-policies/5add76fb6fc16").
	  then()
	  .statusCode(200);
  }
  @Test

  public void validate_json_response()
  {
	  given()
	       .baseUri("https://console-staging.flexiloans.com").
	  when()
	       .get("/policy/attached-policies/5add76fb6fc16").
	  then()
	  
	     .body(
	    		// "result.policies[0].config_name[1]", equalTo("FULLERTON_ECOM"));
	    		 "result.policies.config_name", hasItem("FULLERTON_ECOM"));
 }

  
}

