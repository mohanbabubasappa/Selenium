package testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utility.BrowserFactory;
import utility.ConfigData;

public class BaseTest {
	
	public WebDriver driver;
	public ConfigData config=new ConfigData();
	
	@BeforeClass
	public void setUp()
	{
		driver=BrowserFactory.launchBrowserAndApp(driver, config.getBrowserName(), config.getUrl());
	}
	
	/*
	 * @AfterClass public void tearDown() { BrowserFactory.quitBrowser(driver); }
	 */
	
	public void takeSnapshot(WebDriver driver,String testname)
	{
		File sourceFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File DestFile=new File(System.getProperty("user.dir")+"\\Screenshots\\"+testname+".png");
		
        try 
        {
			FileUtils.copyFile(sourceFile, DestFile);
		} 
        catch (IOException e) 
        {
			e.printStackTrace();
		}
	}

}
