package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.ContactsPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	WebDriver driver;
	
	
	ExcelReader excel = new ExcelReader("TestData\\data.xlsx");
	String username = excel.getCellData("Sheet1", "Username", 2);
	String password = excel.getCellData("Sheet1", "Password", 2);
	
	@Test
	public void validUserShouldbeAbletoLogin() {
		
		
		driver= BrowserFactory.init();
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		
		login.enterUserName(username);
		login.enterPassword(password);
		login.clickSigninButton();
		
		DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);
		dashboard.validateDashboardPage();
		
		
		
	}
	

}
