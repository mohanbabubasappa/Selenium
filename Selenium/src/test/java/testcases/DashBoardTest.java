package testcases;

import org.testng.annotations.Test;

import pages.DashBoardPage;
import pages.HomePage;
import pages.LoginPage;
import utility.ReadExcelFile;

public class DashBoardTest extends BaseTest {
	
	String filepath=System.getProperty("user.dir")+"\\TestData\\Testdata.xlsx";
	String searchtext="HTML for Beginners";
	
	@Test
	void VerifyTestCourses()
	{
		String username=ReadExcelFile.getCellValue(filepath, "Logindata", 1, 0);
		String password=ReadExcelFile.getCellValue(filepath, "Logindata", 1, 1);
		
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		HomePage hp=new HomePage(driver);
		hp.navigateToDashBoard();
		
		DashBoardPage dp=new DashBoardPage(driver);
		dp.SubscribeCourse();
		
		hp.logout();
	}

}
