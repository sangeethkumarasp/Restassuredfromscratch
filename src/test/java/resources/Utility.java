package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utility {
	
	public static RequestSpecification req;
	
	
	public RequestSpecification requestspecification() throws FileNotFoundException
	{
		
		if(req==null)
		{
		PrintStream log =new PrintStream(new FileOutputStream("logging.txt"));
req=new RequestSpecBuilder().setRelaxedHTTPSValidation().setBaseUri(propertymethod("baseUrl")).addFilter(RequestLoggingFilter.logRequestTo(log))
	.addFilter(ResponseLoggingFilter.logResponseTo(log))
	.addQueryParam("key","qaclick123").setContentType(ContentType.JSON).build();

return req;
	}
		return req;
	}
	
	
	
	
	
	public String  propertymethod (String key)
	{
		Properties pr =new Properties();
		
		try {
			FileInputStream fis =new FileInputStream("./src/test/java/resources/global.properties");
			try {
				pr.load(fis);
				
				System.out.println(pr.getProperty("baseUrl"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		
			
		}
		
	return pr.getProperty(key);
		
	}
	
	

}
