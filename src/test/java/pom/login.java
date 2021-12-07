package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import generic.BasePageCrc;

public class login extends BasePageCrc
{
	public login(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='username']")
	public WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	public WebElement password;
	
	@FindBy(xpath = "//input[@class='loginbtn']")
	public WebElement loginbutton;
	
	@FindBy(xpath = "//a[@id='forgotpassword']")
	public WebElement forgotbutton;

	@FindBy(xpath = "(//a[@class='dropdown-item'])[13]")
	public WebElement editbtnclient;
	
	@FindBy(xpath = "(//a[@class='main-a'])[1]")
	public WebElement asserthome;
	
	public void loginScript(String data) throws InterruptedException
	{
	String logindata[]=data.split(",");
	elementvisibility(username);
	Assert.assertTrue(username.isEnabled(), "username is not exists");
	System.out.println("username exists");
	username.sendKeys(logindata[0]);
	elementvisibility(password);
	Assert.assertTrue(password.isEnabled(), "password is not exists");
	System.out.println("password text field exists");
	password.sendKeys(logindata[1]);
	elementvisibility(loginbutton);
	Assert.assertTrue(loginbutton.isEnabled(), "login button is not exists");
	System.out.println("login button exists");
	loginbutton.click();
	elementvisibility(asserthome);
	Assert.assertTrue(asserthome.isEnabled(), "Homepage");
	//Assert.assertFalse(login.asserthome.isEnabled(), "Clientpage");
	System.out.println("Home page is displaying");
	
	
}
}