package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ClientDeletion extends login
{
		public ClientDeletion(WebDriver driver) {
	    super(driver);
	}
		
	@FindBy(xpath = "//a[.='Clients']")
	public WebElement Clients;
		
	@FindBy(xpath = "//input[@id='sname']")
	public WebElement searchfld;
	
	@FindBy(xpath = "//input[@class='green-btn-lined3 w-90-p h-40 p-t-8 inline-block']")
	public WebElement searchbtn;
	
	@FindBy(xpath = "//span[@id='dropdownMenuButton1']")
	public WebElement dropdownbtnclient;

	@FindBy(xpath = "(//a[@class='dropdown-item'])[14]")
	public WebElement deletebtnclient;
	
	@FindBy(xpath = "//a[@id='delete_client']")
	public WebElement deleteclient;	
	
	@FindBy(xpath = "//a[.='Home']")
	public WebElement Home;
	
	public void clientdelete(String data) throws InterruptedException
	{
//		String logindata[]=data.split(",");
		Clients.click();
		elementvisibility(searchfld);
		Assert.assertTrue(searchfld.isEnabled(), "search field not exists");
		System.out.println("search field exists");
		searchfld.click();
		searchfld.sendKeys(data);
		
		elementvisibility(searchbtn);
		Assert.assertTrue(searchbtn.isEnabled(), "search button not exists");
		System.out.println("search button exists");
		searchbtn.click();
		
		elementvisibility(dropdownbtnclient);
		Assert.assertTrue(dropdownbtnclient.isEnabled(), "dropdown button not exists");
		System.out.println("drop down button exists");
		Thread.sleep(30000);
		dropdownbtnclient.click();
		
		elementvisibility(deletebtnclient);
		Assert.assertTrue(deletebtnclient.isEnabled(), "delete button  not exists");
		System.out.println("delete button exists");
		Thread.sleep(5000);
		deletebtnclient.click();
		
		Thread.sleep(8000);
		deleteclient.click();
		
		elementvisibility(Home);
		Assert.assertTrue(Home.isEnabled(), "Home page not exists");
		System.out.println("Home page exists");
		Thread.sleep(8000);
		Home.click();
	}

}
