package generic;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class TestAssert 
{
		 public static void verifyEqual(String value1, String value2)
		 {
		        Assert.assertEquals(value1, value2);
	     }
		 
		 public static void verifyElementVisible(WebElement element)
		 {
		        Assert.assertTrue(element!= null && element.isDisplayed());
		 }
}
