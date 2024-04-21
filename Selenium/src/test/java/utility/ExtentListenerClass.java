package utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener{
	
	ExtentSparkReporter htmlreporter;
	ExtentReports reports;
	ExtentTest test;
	
	public void configureReport()
	{
		htmlreporter=new ExtentSparkReporter("testreport.html");
		reports=new ExtentReports();
		
		//add system info to reports
		reports.setSystemInfo("Machine", "Mohanbabu Balannagari");
		reports.setSystemInfo("OS", "Windows11");
		
		htmlreporter.config().setDocumentTitle("Test Reports");
		htmlreporter.config().setReportName("Report Demo");
		
		htmlreporter.config().setTheme(Theme.STANDARD);
	}
	
	public void onFinish(ITestContext context)
	{
		System.out.println("on finish method invoked");
		reports.flush();
	}
	
	public void onTestFailure(ITestResult result)
	{
		System.out.println("on test failure method invoked");

		configureReport();	

		test=reports.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed Test case is: "+result.getName(), ExtentColor.RED));
		
		test.fail("captured screenshot below: "+test.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+".png"));
	}
	
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("on test success method invoked");
		test=reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the Passed Test case is: "+result.getName(), ExtentColor.GREEN));
	}
	
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("on test skip method invoked");
		test=reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skipped Test case is: "+result.getName(), ExtentColor.ORANGE));
	}

}
