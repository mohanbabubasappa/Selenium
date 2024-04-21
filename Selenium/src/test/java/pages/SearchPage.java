package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class SearchPage {
	
	public WebDriver driver;
	
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//input[@id='search_course'])[1]")
	WebElement searchinput;
	
	@FindBy(xpath="//nav[@role='navigation']//button")
	WebElement searchbtn;

	public void searchCourse(String text)
	{
		searchinput.sendKeys(text);
		searchbtn.click();
	}
}
