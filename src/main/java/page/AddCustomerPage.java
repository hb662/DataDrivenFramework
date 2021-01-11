package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {
	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;

	}

	// Element Library
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Customers')]")
	WebElement CUSTOMER_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Add Customer')]")
	WebElement ADDCUSTOMER_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='account']")
	WebElement FULLNAME_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//select[@id='cid']")
	WebElement COMPANY_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	WebElement EMAIL_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='phone']")
	WebElement PHONE_NUM_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='address']")
	WebElement ADDRESS_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id='city']")
	WebElement CITY_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id='state']")
	WebElement STATE_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id='zip']")
	WebElement ZIP_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//select[@id='country']")
	WebElement COUNTRY_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//button[@id='submit']")
	WebElement SIGNIN_BUTTON_LOCATOR;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'List Customers')]")
	WebElement LIST_CUSTOMER_LOCATOR;

	// Interactive Methods
	public void clickonCustomerButton() {
		CUSTOMER_FIELD_LOCATOR.click();

	}

	public void clickonaddCustomerButton() {
		waitForElement(driver, 3, ADDCUSTOMER_FIELD_LOCATOR);
		ADDCUSTOMER_FIELD_LOCATOR.click();
	}

	String enteredName;

	public void enterFullname(String name) {
		waitForElement(driver, 3, FULLNAME_FIELD_LOCATOR);
		int random = randomNumGenerator();
		enteredName = name + random;
		FULLNAME_FIELD_LOCATOR.sendKeys(enteredName);

	}

	public void enterCompanyname(String company) {
		selectFromDropDown(COMPANY_FIELD_LOCATOR, company);

	}

	public void enterEmail(String email) {
		int random = randomNumGenerator();
		EMAIL_FIELD_LOCATOR.sendKeys(random + email);

	}

	public void enterPhoneNum(String phoneNum) {
		PHONE_NUM_FIELD.sendKeys(phoneNum);
	}

	public void enterAddress(String address) {
		ADDRESS_FIELD_LOCATOR.sendKeys(address);

	}

	public void enterCity(String city) {
		CITY_FIELD_LOCATOR.sendKeys(city);
	}

	public void enterState(String state) {
		STATE_FIELD_LOCATOR.sendKeys(state);
	}

	public void enterZip(String zip) {
		ZIP_FIELD_LOCATOR.sendKeys(zip);
	}

	public void enterCountry(String country) {
		selectFromDropDown(COUNTRY_FIELD_LOCATOR, country);
	}

	public void clickSignInButton() {
		SIGNIN_BUTTON_LOCATOR.click();
	}

	public void clickListOfCustomerButton() throws InterruptedException {
		Thread.sleep(3000);
		LIST_CUSTOMER_LOCATOR.click();
	}

	// tbody/tr[]/td[3]

	// deal with dynamic table
	// tbody/tr[1]/td[3]

	String before_xpath = "//tbody/tr[";
	String after_xpath = "]/td[3]";

	public void verifiedEnteredNameandDelete() throws InterruptedException {
		Thread.sleep(2000);

		for (int i = 1; i <= 5; i++) {
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();

			/*
			 * System.out.println(name); Assert.assertEquals(name, enteredName,
			 * "Enter name does not exist"); break;
			 */

			if (name.contains(enteredName)) {
				System.out.println("Entered name exist. ");
				driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[3]/following-sibling::td[4]/a[2]")).click();
				driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
			}

		}
	}

	/*
	 * public void verifiedEnteredNameandDelete1() { WebElement webelement = driver
	 * .findElement(By.xpath(
	 * "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[2]/table"));
	 * List<WebElement> l = webelement.findElements(By.tagName("td"));
	 * 
	 * for (int i = 0; i < l.size(); i++) {
	 * System.out.println("Total elements present in table are: " + l.size());
	 * System.out.println("table contents: " + l.get(i).getText());
	 * 
	 * } }
	 */
}
