package testcases;

import org.testng.annotations.Test;

import pages.DashBoardPage;
import pages.HomePage;
import pages.LoginPage;
import pages.PaymentPage;
import utility.ReadExcelFile;

public class PaymentTest extends BaseTest {
		
		String filepath=System.getProperty("user.dir")+"\\TestData\\Testdata.xlsx";
		
		@Test
		void VerifyTestCourses()
		{
			String username=ReadExcelFile.getCellValue(filepath, "Logindata", 1, 0);
			String password=ReadExcelFile.getCellValue(filepath, "Logindata", 1, 1);
			String cardnum=ReadExcelFile.getCellValue(filepath, "CardDetails", 0, 0);
			String expdate=ReadExcelFile.getCellValue(filepath, "CardDetails", 0, 1);
			String cvcnumber=ReadExcelFile.getCellValue(filepath, "CardDetails", 0, 2);
			
			LoginPage lp=new LoginPage(driver);
			lp.login(username, password);
			
			HomePage hp=new HomePage(driver);
			hp.navigateToDashBoard();
			
			DashBoardPage dp=new DashBoardPage(driver);
			dp.SubscribeCourse();
			
			PaymentPage pp=new PaymentPage(driver);
			pp.payAmount(cardnum, expdate, cvcnumber);
			
			//hp.logout();
		}
}
