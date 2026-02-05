package pageobjects;

import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
public class HomePage extends BasePage {

	//Constructor
	public HomePage(AndroidDriver driver) {
		super(driver);
	}
	
	//Locators
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
	public WebElement toolbarTitle;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Your Name']")
	public WebElement yourNameLabel;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	public WebElement nameField;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	public WebElement shopButton;
	
	@AndroidFindBy(xpath="//(android.widget.Toast)[1]")
    public WebElement toastMessage;
	
		
	//Action methods
	
	public boolean verifyfieldName() {
	return yourNameLabel.getText().equals("Your Name");
	}
	
	public boolean verifyHomePage() {
		return toolbarTitle.getText().equals("General Store");
	}
	
	public void enterName(String text) {
		nameField.sendKeys(text);
	}
	
	public void clickShop() {
		shopButton.click();
	}
	
	public boolean verifyToastMessage() {
		return toastMessage.getText().equals("Please enter your name");
	}
	
	
}
