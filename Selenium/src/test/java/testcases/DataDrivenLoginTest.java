package testcases;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import pages.HomePage;
import pages.LoginPage;
import utility.ReadExcelFile;

@Listeners
public class DataDrivenLoginTest extends BaseTest {

	String filepath=System.getProperty("user.dir")+"\\TestData\\Testdata.xlsx";

	@Test(priority=1,dataProvider="LoginDataProvider")
	public void VerifyLogin(String username,String password)
	{
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);

		HomePage hp=new HomePage(driver);
		hp.logout();
		
		if(username.equals("mohanbabu777ms@gmail.com")&&password.equals("Mohanbabu@123"))
		{
			System.out.println("Test is passed");
			Assert.assertTrue(true);
			hp.logout();
		}
		else
		{
			takeSnapshot(driver,"VerifyLogin");
			Assert.assertTrue(false);
		}		
	}

	@DataProvider(name="LoginDataProvider")
	public String[][] LoginDataProvider()
	{
		int rowcount=ReadExcelFile.getRowCount(filepath, "Logindata");
		int columncount=ReadExcelFile.getColumnCount(filepath, "Logindata");

		String data[][]=new String[rowcount-1][columncount];

		for(int i=1;i<rowcount;i++)
		{
			for(int j=0;j<columncount;j++)
			{
				data[i-1][j]=ReadExcelFile.getCellValue(filepath, "Logindata", i, j);
			}
		}

		return data;
	}
}
