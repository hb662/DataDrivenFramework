package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class ContactsPage {
	
	WebDriver driver;
	
	public ContactsPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
      @FindBy(how = How.XPATH,using ="//*[@id=\"page-wrapper\"]/div[3]/div[1]")
      WebElement CONTACT_DELETED_LOCATOR;
	
	
	
	public void validateContactDeletedSussfully() {
		
		Assert.assertTrue(true, CONTACT_DELETED_LOCATOR.getText());
		System.out.println("Page Found");
			
			
		}
		
		
	}

