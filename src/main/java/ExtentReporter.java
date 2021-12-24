import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReporter 
{
	
	 ExtentHtmlReporter htmlReporter;
	 ExtentReports extent;
	
	@BeforeSuite
	public void setup() {
		 htmlReporter = new ExtentHtmlReporter("extent.html");	
	     extent = new ExtentReports();
	     extent.attachReporter(htmlReporter);
	}
	
	@Test
	public void test1() throws Exception {
		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
		
	    // log(Status, details)
        test.log(Status.INFO, "This step shows usage of log(status, details)");

        // info(details)
        test.info("This step shows usage of info(details)");
        
        // log with snapshot
        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        
        // test with snapshot
        test.addScreenCaptureFromPath("screenshot.png");
	}
	
	@AfterSuite
	public void tearDown() {
		// calling flush writes everything to the log file
        extent.flush();
	}
}
