package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
	
public WebDriver driver;
	
	public PaymentPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="label[for='payment_method_stripe']")
	WebElement paystripebtn;
	
	@FindBy(css="#learn-press-checkout-place-order")
	WebElement placeorderbtn;
	
	@FindBy(xpath="//iframe[@title='Secure card payment input frame']")
	WebElement framename;
	
	@FindBy(name="cardnumber")
	WebElement cardnum;
	
	@FindBy(name="exp-date")
	WebElement expirydate;
	
	@FindBy(name="cvc")
	WebElement cvcnum;
	
	@FindBy(css="#payment-button")
	WebElement paybtn;
	
	public void payAmount(String cardnumber,String expdate,String cvcnumber)
	{
		paystripebtn.click();
		placeorderbtn.click();
		
		driver.switchTo().frame(framename);
		cardnum.sendKeys(cardnumber);
		expirydate.sendKeys(expdate);
		cvcnum.sendKeys(cvcnumber);
		
		driver.switchTo().defaultContent();
		paybtn.click();
	}

}
