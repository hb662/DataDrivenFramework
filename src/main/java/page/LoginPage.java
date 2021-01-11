package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}
	@FindBy(how = How.ID, using ="username")WebElement USER_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id ='password']") WebElement PASSWORD_ELEMENT;
	@FindBy(how = How.XPATH, using ="//button[contains(text(),'Sign in')]") WebElement SIGIN_ELEMENT;

	//Interactive method
	public void enterUserName(String userName) {
		USER_NAME_ELEMENT.sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		PASSWORD_ELEMENT.sendKeys(password);
		
	}
	 
	public void clickSigninButton() {
		SIGIN_ELEMENT.click();
		
	}
	

}
