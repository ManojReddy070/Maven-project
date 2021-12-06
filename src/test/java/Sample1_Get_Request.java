import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Sample1_Get_Request {
	
	@Test
	void UserDetails() 
	
	{
		//baseURI
		RestAssured.baseURI="https://app.sandbox.creditheroscore.com";
		//request obj
		RequestSpecification httpRequest=RestAssured.given();
		
		//response obj
		Response  res=httpRequest.request(Method.GET,"/site/customer-credit-report?email=manojreddy@systemadmin.com&password=Test@123&type=json-tucreportv6");
		
		//print response
		String responsebody=res.getBody().asString();
		System.out.println(responsebody);
		
		//validation  status code
		int statuscode=res.getStatusCode();
		System.out.println("statuscode is :" +statuscode);
		Assert.assertEquals(200, statuscode);
		
		//Statusline verification
		String statusline=res.getStatusLine();
		System.out.println("Statusline is :" +statusline);
		Assert.assertEquals("HTTP/1.1 200 OK", statusline);		
	}
}
