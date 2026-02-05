package pageobjects;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utilities.MobileGestures;

public class CartPage extends BasePage{

	//Constructor
	public CartPage(AndroidDriver driver) {
		super(driver);
	}
	
	//Locators
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productName")
	public WebElement productAdded;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	public WebElement termsOfCond;
	
	@AndroidFindBy(id ="com.androidsample.generalstore:id/alertTitle")
	public WebElement alertTitle;
	
	@AndroidFindBy(className = "android.widget.CheckBox")
	public WebElement checkbox;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	public WebElement completePurchaseBtn;
	
	//Action methods
	
	public boolean verifyProductAdded() {
		return productAdded.getText().equalsIgnoreCase("Jordan 6 Rings");
	}
	
	public void longClickTermsOfConditions() {
		MobileGestures mb = new MobileGestures(driver);
		mb.longClick(termsOfCond);
	}
	
	public boolean verifyAlertTitle() {
		
		return alertTitle.getText().equals("Terms Of Conditions");
	}
	
	public void clickCheckbox() {
		
		checkbox.click();
	}
	
	public void clickCompletePurchase() {
		completePurchaseBtn.click();
	}

}
 