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
		elementvisibility(Clients);
		Assert.assertTrue(assertclient.isEnabled(), "Client tab not exists");
		System.out.println("Client tab exists");
	    Clients.click();
	    
	    elementvisibility(Addnewclientbutton);
	    Assert.assertTrue(Addnewclientbutton.isEnabled(), "Addnewclient button not exists");
	    System.out.println("Addnewclient button exists");
		Addnewclientbutton.click();
		
		elementvisibility(firstname);
		Assert.assertTrue(firstname.isEnabled(), "firstname text field not exists");
		System.out.println("firstname text field exists");
		firstname.sendKeys(logindata[2]);
		
		elementvisibility(lastname);
		Assert.assertTrue(lastname.isEnabled(), "lastname text field not exists");
		System.out.println("lastname text field exists");
		lastname.sendKeys(logindata[3]);
		
		elementvisibility(email);
		Assert.assertTrue(email.isEnabled(), "email text field not exists");
		System.out.println("email text field exists");
		email.sendKeys(logindata[4]);
		
		elementvisibility(Savebutton);
		Assert.assertTrue(Savebutton.isEnabled(), "savebutton not exists");
		System.out.println("savebutton exists");
		Savebutton.click();
		
		elementvisibility(Okbutton);
		Assert.assertTrue(Okbutton.isEnabled(), "Okbutton not exists");
		System.out.println("Okbutton exists");
		Okbutton.click();
		
		String msg = Clientsucessfullmsg.getText();
		Reporter.log(msg);	
	}
}

