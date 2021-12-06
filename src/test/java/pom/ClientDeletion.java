package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
		String logindata[]=data.split(",");
		Clients.click();
		searchfld.click();
		searchfld.sendKeys(logindata[8]);
		Thread.sleep(5000);
		searchbtn.click();
		Thread.sleep(5000);
		dropdownbtnclient.click();
		Thread.sleep(5000);
		deletebtnclient.click();
		Thread.sleep(5000);
		deleteclient.click();
		Thread.sleep(5000);
		Home.click();
	}

}
