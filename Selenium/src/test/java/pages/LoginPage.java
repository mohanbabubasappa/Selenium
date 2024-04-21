package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="loginlabel")
	WebElement loginLink;
	
	@FindBy(xpath="//input[@id='user_login']")
	WebElement usernameTxtBox;
	
	@FindBy(xpath="//input[@name='pwd']")
	WebElement passwordTxtBox;
	
	@FindBy(id="wp-submit")
	WebElement loginBtn;
	
	
	
	public void login(String username,String password)
	{
		loginLink.click();
		usernameTxtBox.sendKeys(username);
		passwordTxtBox.sendKeys(password);
		loginBtn.click();
	}
	
}
