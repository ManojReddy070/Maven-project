package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

public class Addnewclient extends login
{	
	public Addnewclient(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//a[.='Clients']")
	public WebElement Clients;
	
	@FindBy(xpath = "//a[@id='mySmallModalLabel']")
	public WebElement Addnewclientbutton;
	
	@FindBy(xpath = "//input[@id='fname']")
	public WebElement firstname;
	
	@FindBy(xpath = "//input[@id='lname']")
	public WebElement lastname;
	
	@FindBy(xpath = "//input[@id='email']")
	public WebElement email;
	
	@FindBy(xpath = "//span[@id='select2-referred_by_dd-container']")
	public WebElement Reffereddropdown;
	
	@FindBy(xpath = "(//span[.='No'])[4]")
	public WebElement portalaccessdropdown;
	
	@FindBy(xpath = "//li[.='Yes']")
	public WebElement yesbtn;

	@FindBy(xpath = "//input[@id='sub_button']")
	public WebElement Savebutton;
	
	@FindBy(xpath = "//a[@class='m-r-24 btn green-btn form-btn waves-effect waves-light no-shadow']")
	public WebElement Okbutton;

	@FindBy(xpath = "//div[@id='flash-message']")
	public WebElement Clientsucessfullmsg;
	
	@FindBy(xpath = "//a[@value= 'Close']")
	public WebElement Cancelbutton;
	
	@FindBy(xpath = "//a[.='Clients']")
	public WebElement assertclient;
	
	public void Addclient(String data) throws InterruptedException
	{
		String logindata[]=data.split(",");
	    Clients.click();
	    Assert.assertTrue(assertclient.isEnabled(), "Clientpage");
	    System.out.println("client page is displaying");
		Addnewclientbutton.click();
		firstname.sendKeys(logindata[2]);
		lastname.sendKeys(logindata[3]);
		email.sendKeys(logindata[4]);
		Savebutton.click();
		Okbutton.click();
		String msg = Clientsucessfullmsg.getText();
		Reporter.log(msg);	
		
	}
}

