package test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.LoginData;
import utilities.Utilities;

public class LoginTest extends BaseClass {

	@BeforeMethod
	public void StartTime() {

		System.out.println("Start Time : " + LocalDateTime.now());
	}

	@Test(enabled=true)
	public void Test1() throws IOException {
		
		Properties property = Utilities.getProperty();
		LoginPage loginPage = new LoginPage(getDriver());
		String url = property.getProperty("clientUrl");
	    getDriver().get(url);		
		String currentUrl = loginPage.GetCurrecntUrl();
		loginPage.HardAssertEquals(currentUrl, url);
		String userLoginName = property.getProperty("staffUserName1");
		String userLoginPassword = property.getProperty("staffUserPassword1");
		loginPage.LoginUserName(userLoginName);	
		loginPage.LoginUserPass(userLoginPassword);	
		loginPage.SigninBtnClick();
		loginPage.LogoisDisplayed();		
		System.out.println("Properties file used user name and pass filled");
	}

	@Test(priority=1,invocationCount=2,enabled=true)
	
	//priority if we set means it will run the first priority test case based on ascending order
	//invocationCount if we set means it will run the test case more time based on count at the same time set 0 means it will ignore the test case
	//@ignore annotations if we use means test case will be ignore - 1st option 
	//enabled=false if we use this option to parameter means that test case will ignored  - 2nd option
		
	public void Test2() throws IOException {

		Properties property = Utilities.getProperty();
		LoginPage loginPage = new LoginPage(getDriver());
		String url = property.getProperty("clientUrl");
		getDriver().get(url);
		String username = ExcelUtility.getData(1, 0);
		String password = ExcelUtility.getData(1, 1);
		loginPage.LoginUserName(username);
		loginPage.LoginUserPass(password);
		loginPage.SigninBtnClick();		
		// Assert.fail("Test2 Failed");
		System.out.println("Excel file used user name and pass filled");
	}

	@Test(enabled=false)
	public void Test3() throws IOException {

		Properties property = Utilities.getProperty();
		LoginPage loginPage = new LoginPage(getDriver());
		String url = property.getProperty("clientUrl");
		getDriver().get(url);
		String userLoginName = property.getProperty("staffUserName3");
		String userLoginPassword = property.getProperty("staffUserPassword3");
		loginPage.LoginUserName(userLoginName);
		loginPage.LoginUserPass(userLoginPassword);
		loginPage.SigninBtnClick();
		Assert.fail("Test2 Failed");
	}

	@Test( enabled=true,dataProvider="LoginData",dataProviderClass = LoginData.class)
	public void Test4(String user, String pass) throws Exception  {
		
		Properties property = Utilities.getProperty();
		LoginPage loginPage = new LoginPage(getDriver());
		String url = property.getProperty("clientUrl");
		getDriver().get(url);
		loginPage.LoginUserName(user);
		loginPage.LoginUserPass(pass);
		loginPage.SigninBtnClick();
		System.out.println("DataProvider and parallel used user name and pass filled");
	}

	@AfterMethod
	public void EndTime() {

		System.out.println("End Time : " + LocalDateTime.now());
	}
}
