package stepdefinitions;


import static org.junit.Assert.assertEquals;
import static org.testng.AssertJUnit.assertEquals;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;
import resources.Resouces;
import resources.TestDataBuild;
import resources.Utility;
import static io.restassured.RestAssured.given;


import java.io.FileNotFoundException;

public class Stepdefs extends Utility {
	ResponseSpecification resspec;
	RequestSpecification res;
	TestDataBuild data =new TestDataBuild();
	Response response;
	static String place_id;
	
	
	
	
	@Given("user with addplace payload with {string} {string} {string}")
	public void user_with_addplace_payload_with(String name, String language, String address) throws FileNotFoundException {
		
		res=given().spec(requestspecification()).body(data.addPlacePayLoad(name, language, address));
		
	
	  
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String crudmethod) {
		
		
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		Resouces apiresources=	Resouces.valueOf(resource);
		
	   System.out.println(apiresources.getresouces());
	   
	   if(crudmethod.equalsIgnoreCase("post"))
	   {
		 response=  res.when().post(apiresources.getresouces());
	   }else if(crudmethod.equalsIgnoreCase("GET"))
	   {
		   response =  res.when().get(apiresources.getresouces());
	   }
	   
	   
	  
	}

	@Then("api call got sucess with status code {int}")
	public void api_call_got_sucess_with_status_code(Integer int1) {
//Assert.assertEquals(response.getStatusCode(),200);

assertEquals(response.getStatusCode(),200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyvalue, String Expectedvalue) {
		
		 assertEquals(getjsonpath(response,keyvalue),Expectedvalue);
	  
	}

	
	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_Id_created_maps_to_using(String expectedName, String resource) throws FileNotFoundException {
		
		 place_id=getjsonpath(response,"place_id");
		 res=given().spec(requestspecification()).queryParam("place_id",place_id);
		 user_calls_with_http_request(resource,"GET");
		 String actualname=getjsonpath(response,"name");
		 assertEquals(actualname,expectedName);
		 
		
		
	   
	}

}
