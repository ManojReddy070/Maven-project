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
		
		//@Test
		public void passTest()
		{

			logger = extent.startTest("passTest");
			Assert.assertTrue(true);
			logger.log(LogStatus.PASS, "Test Case Passed is passTest");
		}
		
		//@Test
		public void failTest()
		{
			logger = extent.startTest("failTest");
			Assert.assertTrue(false);
			logger.log(LogStatus.PASS, "Test Case (failTest) Status is passed");
		}

		//@Test
		public void skipTest()
		{
			logger = extent.startTest("skipTest");
			throw new SkipException("Skipping - This is not ready for testing ");
		}
		
		@AfterMethod
		public void getResult(ITestResult result)
		{
			if(result.getStatus() == ITestResult.FAILURE)
			{
				logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
				logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
			}
			else if(result.getStatus() == ITestResult.SKIP)
			{
				logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
			}
			else if(result.getStatus() == ITestResult.SUCCESS)
			{
				logger.log(LogStatus.PASS, "Test Case Success is "+result.getName());
			}
			

//			extent.endTest(logger);
//			String name = result.getMethod().getMethodName();
//			int status = result.getStatus();
//			if(status==2)
//				ExtentreporterNG.getphoto(driver, name);
//			driver.close();
		}

//		public static void getphoto(WebDriver driver, String name)
//		{
//			TakesScreenshot shot=(TakesScreenshot)driver;
//			File src = shot.getScreenshotAs(OutputType.FILE);
//			File dest=new File("./src/screenshots/"+name+".png");
//			try 
//			{
//				FileUtils.copyFile(src, dest);
//			} 
//			catch (IOException e) 
//			{
//
//			}
//		}
		
		@AfterTest
		public void endReport()
		{

			extent.flush();
			extent.close();
		}
		
//		public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
//			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//			TakesScreenshot ts = (TakesScreenshot) driver;
//			File source = ts.getScreenshotAs(OutputType.FILE);
//			// after execution, you could see a folder "FailedTestsScreenshots"
//			// under src folder
//			String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
//					+ ".png";
//			File finalDestination = new File(destination);
//			FileUtils.copyFile(source, finalDestination);
//			return destination;
//		}
//		@AfterMethod
//		public void tearDown(ITestResult result) throws IOException{
//			
//			if(result.getStatus()==ITestResult.FAILURE){
//				extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
//				extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
//				
//				String screenshotPath = ExtentreporterNG.getScreenshot(driver, result.getName());
//				extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
//				//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
//			}
//			else if(result.getStatus()==ITestResult.SKIP){
//				extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
//			}
//			else if(result.getStatus()==ITestResult.SUCCESS){
//				extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());
//
//			}
//	}
}

