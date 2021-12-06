package scripts.crc;

import org.testng.annotations.Test;
import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTestCrc;
import pom.login;

public class loginscrpit extends BaseTestCrc
{
	@Test(dataProvider="logindataset")
	public void loginScript(String data) throws InterruptedException
	{
		
		String logindata[]=data.split(",");
		login a=new login (driver);
		a.username.sendKeys(logindata[0]);
		a.password.sendKeys(logindata[1]);
		a.loginbutton.click();
//		String home=a.asserthome.getText();		
//		Assert.assertTrue("Homefailed", home.contains("Client") );
//		Assert.assertTrue("Homefailed", a.asserthome.isDisplayed());
//		System.out.println("Assertion sucess");
	}
}
