package pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardPage {
	
	public WebDriver driver;
	
	public DashBoardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Offered Academies")
	WebElement offeredacademieslink;
	
	@FindBy(xpath="//li[1]//form[1]//div[1]//button[1]")
	WebElement subcribebutton;
	
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	
	
	public void SubscribeCourse()
	{	
		offeredacademieslink.click();
		
		Actions action = new Actions (driver); 
		action.moveToElement (subcribebutton);
		
		//jse.executeScript("arguments[0].scrollIntoView(true);",subcribebutton);
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(subcribebutton));
		
		subcribebutton.click();
	}

}
