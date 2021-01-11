package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.ContactsPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {

	WebDriver driver;

	ExcelReader excel = new ExcelReader("testData\\data.xlsx");
	String username = excel.getCellData("Sheet1", "UserName", 2);
	String password = excel.getCellData("Sheet1", "Password", 2);
	String name = excel.getCellData("Sheet2", "FullName", 2);
	String company = excel.getCellData("Sheet2", "Company", 2);
	String email = excel.getCellData("Sheet2", "Email", 2);
	String phoneNum = excel.getCellData("Sheet2", "Phone", 2);
	String address = excel.getCellData("Sheet2", "Address", 2);
	String city = excel.getCellData("Sheet2", "City", 2);
	String state = excel.getCellData("Sheet2", "State", 2);
	String zip = excel.getCellData("Sheet2", "Zip", 2);
	String country = excel.getCellData("Sheet2", "Country", 2);

	@Test
	public void userShouldbealbetoAddCustomer() throws InterruptedException {

		driver = BrowserFactory.init();

		LoginPage login = PageFactory.initElements(driver, LoginPage.class);

		login.enterUserName(username);
		login.enterPassword(password);
		login.clickSigninButton();

		DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);
		dashboard.validateDashboardPage();

		AddCustomerPage page = PageFactory.initElements(driver, AddCustomerPage.class);

		page.clickonCustomerButton();
		page.clickonaddCustomerButton();
		page.enterFullname(name);
		page.enterCompanyname(company);
		page.enterEmail(email);
		page.enterPhoneNum(phoneNum);
		page.enterAddress(address);
		page.enterCity(city);
		page.enterState(state);
		page.enterZip(zip);
		page.enterCountry(country);
		page.clickSignInButton();
		page.clickListOfCustomerButton();
		page.verifiedEnteredNameandDelete();

		ContactsPage contactspage = PageFactory.initElements(driver, ContactsPage.class);
		contactspage.validateContactDeletedSussfully();

	}
}
