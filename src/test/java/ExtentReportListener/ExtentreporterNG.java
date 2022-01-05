package ExtentReportListener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import generic.UtilityCrc;
import scripts.crc.Crc_Test;

public class ExtentreporterNG
{	
		protected ExtentReports extent;
		protected ExtentTest logger;
		public ExtentTest extentTest;
		private WebDriver driver;
		
		@BeforeTest
		public void startReport()
		{
			//location of the repoort
			extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/ExtentReport.html", true);
			//extent.addSystemInfo("Environment","Environment Name")
			extent
			.addSystemInfo("Host Name", "CRC")
			.addSystemInfo("Environment", "Automation Testing")
			.addSystemInfo("User Name", "Tester");
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
		}
				
//		@AfterMethod
//		public void getResult(ITestResult result) throws IOException
//		{
//			if(result.getStatus() == ITestResult.FAILURE)
//			{
//				logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
//				logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
//				ExtentreporterNG.getphoto(driver, "name");
//			}
//			else if(result.getStatus() == ITestResult.SKIP)
//			{
//				logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
//			}
//			else if(result.getStatus() == ITestResult.SUCCESS)
//			{
//				logger.log(LogStatus.PASS, "Test Case Success is "+result.getName());
//			}
		@AfterMethod
		public void getResult(ITestResult result) throws IOException
		{
			if(result.getStatus() == ITestResult.FAILURE)
			{
				logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
				ExtentreporterNG.getphoto(driver, "name");
			}
			else if(result.getStatus() == ITestResult.SKIP)
			{
				logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
			}
			else if(result.getStatus() == ITestResult.SUCCESS)
			{
				logger.log(LogStatus.PASS, "Test Case Success is "+result.getName());
			}
			
			extent.endTest(logger);
		}

//			String name = result.getMethod().getMethodName();
//			int status = result.getStatus();
//			if(status==2) {
//				
//				
//			}
//			driver.close();
		

		public static String getphoto(WebDriver driver, String name) throws IOException
		{
			TakesScreenshot shot=(TakesScreenshot)driver;
			File src = shot.getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir") + "/src/screenshots/" + name + ".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(src, finalDestination);
			return destination;
		}
		
		@AfterTest
		public void endReport()
		{

			extent.flush();
			extent.close();
		}
}

