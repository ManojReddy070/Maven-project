package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

public class ImportCreditreport_MyScoreIQ extends login
{
	public ImportCreditreport_MyScoreIQ(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//a[@class='green-btn-lined2 inline-block text-center h-40 p-t-7 m-r-24 green-bg text-white']")
	public WebElement importauditbtn;
	
	@FindBy(xpath = "//a[@class='green-btn et-padding btnsubmit']")
	public WebElement importreportnowbtn;
	
	@FindBy(xpath = "(//span[.='Choose Supported Provider'])[5]")
	public WebElement choosesuptpvdrbtn;
	
	@FindBy(xpath = "//li[.='MyScoreIQ']")
	public WebElement MyScoreIQ;
	
	@FindBy(xpath = "//input[@id='auto_vcr_username']")
	public WebElement usrname;
	
	@FindBy(xpath = "//input[@id='auto_vcr_password']")
	public WebElement passwor;
	
	@FindBy(xpath = "//input[@id='auto_vcr_phonenumber']")
	public WebElement phonenum;
	
	@FindBy(xpath = "//input[@id='auto_vcr_securityword']")
	public WebElement SecurityWord;
	
	@FindBy(xpath = "//input[@id='auto_vcr_note']")
	public WebElement Notes;
	
	@FindBy(xpath = "(//a[@id='auto_btnsubmit_with_pending'])[2]")
	public WebElement importrunbtn;
	
	@FindBy(xpath = "//div[@id='flashmessage']")
	public WebElement Auditcreatedsucesspopupmsg;
	
	@FindBy(xpath = "(//button[@class='close'])[11]")
	public WebElement reportclosebutton;
	
	@FindBy(xpath = "(//a[@id='auto_btnsubmit_without_pending'])[2]")
	public WebElement idontneedjustimbtn;	
					
	@FindBy(xpath = "(//a[@class='modal-close-text blue'])[2]")
	public WebElement cancelbtn;	
	
	@FindBy(xpath = "(//div[@class='modal-header'])[14]/.//button[.='×']/.")
	public WebElement closebutton;
	
	@FindBy(xpath = "//button[@class='btn green-btn padding-btn3 waves-effect waves-light h-40 p-t-b-8']")
	public WebElement nextbutton;
	
	public void importMyScoreIQ(String data) throws InterruptedException
	{
		String logindata[]=data.split(",");
		elementvisibility(importauditbtn);
		Assert.assertTrue(importauditbtn.isEnabled(), "importaudit button not exists");
		System.out.println("import audit button exists");
		importauditbtn.click();
		
		elementvisibility(importreportnowbtn);
		Assert.assertTrue(importreportnowbtn.isEnabled(), "import report button not exists");
		System.out.println("import report button exists");
		importreportnowbtn.click();
		
		Thread.sleep(5000);
		elementvisibility(choosesuptpvdrbtn);
		Assert.assertTrue(choosesuptpvdrbtn.isEnabled(), "choose support provider button not exists");
		System.out.println("choose support provider button exists");
		choosesuptpvdrbtn.click();
		
		elementvisibility(MyScoreIQ);
		Assert.assertTrue(MyScoreIQ.isEnabled(), "Mysocreiq provider not exists");
		System.out.println("MyscoreIQ provider exists");
		MyScoreIQ.click();
		
		elementvisibility(usrname);
		Assert.assertTrue(usrname.isEnabled(), "user name txt field not exists");
		System.out.println("user name text field exists");
		usrname.sendKeys(logindata[5]);
		
		elementvisibility(passwor);
		Assert.assertTrue(passwor.isEnabled(), "password text field not exists");
		System.out.println("password text field exists");
		passwor.sendKeys(logindata[6]);
		
		elementvisibility(phonenum);
		Assert.assertTrue(phonenum.isEnabled(), "phone number text field not exists");
		System.out.println("phone number text field exists");
		phonenum.sendKeys(logindata[7]);
		
		elementvisibility(SecurityWord);
		Assert.assertTrue(SecurityWord.isEnabled(), "SSN not exists");
		System.out.println("SSN exists");
		SecurityWord.sendKeys(logindata[8]);
		
		elementvisibility(importrunbtn);
		Assert.assertTrue(importrunbtn.isEnabled(), "import run button not exists");
		System.out.println("import run button exists");
		importrunbtn.click();
		
		Thread.sleep(5000);
		String mesg = Auditcreatedsucesspopupmsg.getText();
		Reporter.log(mesg);
		Thread.sleep(5000);
		nextbutton.click();
	}
}
