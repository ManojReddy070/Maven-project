package generic;

import java.io.FileReader;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class BaseTestCrc implements Autoconstantcrc 
{
	public WebDriver driver;
	@DataProvider(name="logindataset")
	public String[] readJson2() throws Throwable, ParseException
	{	
		JSONParser jsonParser=new JSONParser();
		FileReader reader=new FileReader("./src/data/logindataset.json");
		Object obj = jsonParser.parse(reader);
		JSONObject logindataJsonobj = (JSONObject)obj;
		JSONArray logindataArray=(JSONArray)logindataJsonobj.get("logindata");
		String arr[]=new String[logindataArray.size()];
		
		for(int i=0; i<logindataArray.size();i++)
		{	
			JSONObject users = (JSONObject)logindataArray.get(i);
			String username=(String)users.get("username");
			String password=(String)users.get("password");
			String firstname=(String)users.get("firstname");
			String lastname=(String)users.get("lastname");
			String email=(String)users.get("email");
			String usrname=(String)users.get("usrname");
			String passwor=(String)users.get("passwor");
			String phonenumber=(String)users.get("phonenumber");
			String ssn=(String)users.get("ssn");
			String searchfld=(String)users.get("searchfld");
			
			arr[i]=username+","+password+","+firstname+","+lastname+","+email+","+usrname+","+passwor+","+phonenumber+","+ssn+","+searchfld;
		}
		reader.close();
		return arr;
	}
@BeforeMethod()
@Parameters({"browser","url","WindowSize", "Execution-Type", "notifications"})
public void precondition(String browserName, String url, String WindowSize, String ET, String notifications) throws InterruptedException
{
	System.out.println("Browser Name is: "+browserName);
	if(browserName.equalsIgnoreCase("chrome"))
	{
		System.setProperty(chromekey, chromevalue);
		ChromeOptions options= new ChromeOptions();
		//options.setHeadless(true);
		options.addArguments(WindowSize);
		options.addArguments(notifications);
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		Dimension size = driver.manage().window().getSize();
		System.out.println(size);
	}
	else if(browserName.equalsIgnoreCase("firefox1"))
	{
		System.setProperty(geckokey, geckovalue);
		FirefoxOptions options= new FirefoxOptions();
	    //options.setHeadless(true);
		driver = new FirefoxDriver(options);
		Dimension d=new Dimension(1900, 1080);
		driver.manage().window().setSize(d);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		Dimension size = driver.manage().window().getSize();
		System.out.println(size);
	}
	else if(browserName.equalsIgnoreCase("firefox2"))
	{
		System.setProperty(geckokey, geckovalue);
		FirefoxOptions options= new FirefoxOptions();
		//options.setHeadless(true);
		driver = new FirefoxDriver(options);
		Dimension d=new Dimension(411, 731);
		driver.manage().window().setSize(d);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		Dimension size = driver.manage().window().getSize();
		System.out.println(size);
	}
	else if(browserName.equalsIgnoreCase("firefox3"))
	{
		System.setProperty(geckokey, geckovalue);
		FirefoxOptions options= new FirefoxOptions();
		//options.setHeadless(true);
		driver = new FirefoxDriver(options);
		Dimension d=new Dimension(768, 1024);
		driver.manage().window().setSize(d);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		Dimension size = driver.manage().window().getSize();
		System.out.println(size);
	}
}

@AfterMethod
public void postcondition(ITestResult r)
{
	String name = r.getMethod().getMethodName();
	int status = r.getStatus();
	if(status==2)
		UtilityCrc.getphoto(driver, name);
	//driver.close();
}

}

