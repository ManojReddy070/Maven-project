package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReimportCreditreport extends login
{
	public ReimportCreditreport(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@id='btnsourcecode']")
	public WebElement reimportbutton;

	@FindBy(xpath = "//a[@id='go_to_pending_report']")
	public WebElement yespendingbutton;
	
	@FindBy(xpath = "(//button[@class='close'])[16]")
	public WebElement closebutton;
			
	@FindBy(xpath = "//span[@id='select2-pr_experian_status_0-container']")
	public WebElement negtiveexperianbutton;
			
	@FindBy(xpath = "//li[@id='select2-pr_experian_status_0-result-4wbw-1']")
	public WebElement positiveexperianbutton;
	
	@FindBy(xpath = "//span[@id='select2-pr_equifax_status_1-container']")
	public WebElement negativeequifixbutton;
	
	@FindBy(xpath = "//span[@id='select2-pr_equifax_status_1-container']")
	public WebElement positiveequfixbutton;
	
}
