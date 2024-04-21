package testcases;

import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseTest{
	
	String username="mohanbabu777ms@gmail.com";
	String password="Mohanbabu@123";
	
	@Test
	void verifyLogin()
	{	
		LoginPage lp=new LoginPage(driver);
		lp.login(username,password);
	}
	
	

}
