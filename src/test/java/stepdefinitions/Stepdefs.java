package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.Utility;

public class Stepdefs extends Utility {
	
	
	
	
	
	
	@Given("user with addplace payload with {string} {string} {string}")
	public void user_with_addplace_payload_with(String string, String string2, String string3) {
		
		
		
	  
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String string, String string2) {
	   
	}

	@Then("api call got sucess with status code {int}")
	public void api_call_got_sucess_with_status_code(Integer int1) {
	    
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String string, String string2) {
	  
	}

	@Then("scope in response body is {string}")
	public void scope_in_response_body_is(String string) {
	    
	}

	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_Id_created_maps_to_using(String string, String string2) {
	   
	}

}
