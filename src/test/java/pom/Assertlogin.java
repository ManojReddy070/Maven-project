package pom;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.TestAssert;

public class Assertlogin extends TestAssert
{
		private WebDriver driver;

		public Assertlogin(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		public void getAddNewClientPage()
		{	
			String AddNewClientURL= "https://ui-test.creditrepaircloud.com/myclients/add/?from=clientlist";
			Assert.assertEquals(AddNewClientURL, driver.getCurrentUrl());
		}		
}

