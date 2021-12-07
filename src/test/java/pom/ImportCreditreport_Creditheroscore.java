package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ImportCreditreport_Creditheroscore extends login
{
	public ImportCreditreport_Creditheroscore(WebDriver driver) {
			super(driver);
		}
		@FindBy(xpath = "//a[@class='green-btn-lined2 inline-block text-center h-40 p-t-7 m-r-24 green-bg text-white']")
		public WebElement importauditbtn;
		
		@FindBy(xpath = "//a[@class='green-btn et-padding btnsubmit']")
		public WebElement importreportnowbtn;
		
		@FindBy(xpath = "(//span[.='Choose Supported Provider'])[5]")
		public WebElement choosesuptpvdrbtn;
		
		@FindBy(xpath = "//li[.='CreditHeroScore']")
		public WebElement Chs;
		
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
		
		@FindBy(xpath = "//button[@class='btn green-btn padding-btn3 waves-effect waves-light h-40 p-t-b-8']")
		public WebElement nextbtn;
		
		public void importChs(String data) throws InterruptedException
		{
			String logindata[]=data.split(",");
			importauditbtn.click();
			importreportnowbtn.click();
			Thread.sleep(5000);
			choosesuptpvdrbtn.click();
			Chs.click();
			Thread.sleep(4000);
			importrunbtn.click();
			Thread.sleep(5000);
			String mesg = Auditcreatedsucesspopupmsg.getText();
			Reporter.log(mesg);
	}
}

