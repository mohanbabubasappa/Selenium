package testcases;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;
import utility.ReadExcelFile;

public class SearchTest extends BaseTest {
	
	String filepath=System.getProperty("user.dir")+"\\TestData\\Testdata.xlsx";
	
	@Test
	void VerifySearch()
	{
		String username=ReadExcelFile.getCellValue(filepath, "Logindata", 1, 0);
		String password=ReadExcelFile.getCellValue(filepath, "Logindata", 1, 1);
		String searchtext=ReadExcelFile.getCellValue(filepath, "SearchText", 0, 0);

		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		SearchPage sp=new SearchPage(driver);
		sp.searchCourse(searchtext);
		
		HomePage hp=new HomePage(driver);
		hp.logout();
	}

}
