package pageobjects;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.SupportsContextSwitching;

public class PurchasePage extends BasePage {

	//Constructor
	public PurchasePage(AndroidDriver driver) {
	
		super(driver);
	}
	
	//Locators
	
	@FindBy(name ="q")
	public WebElement fieldText;
	
	//Action methods
	
	public void enterTextAndEnter(String text) {
		fieldText.sendKeys(text);
		fieldText.sendKeys(Keys.ENTER);
	}
	
	public void waitForWebView() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    
	    wait.until(driver -> {
	        Set<String> contexts = ((SupportsContextSwitching) driver).getContextHandles();
	        for (String context : contexts) {
	            if (context.contains("WEBVIEW")) {
	                return true;
	            }
	        }
	        return false;
	    });
	}

}
