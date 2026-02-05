package pageobjects;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BasePage {
	
	AndroidDriver driver;
	
	//Constructor
	public BasePage(AndroidDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(
			    new AppiumFieldDecorator(driver, Duration.ofSeconds(10)),
			    this);
		}
	
	//Generic action methods (not specific to any page)
	
	//UiSelector().scrollable(true) - Identify that container as scrollable
		//new UiScrollable - create a scrollable container
		//scrollTextintoView - scrolls until the specific text appears into view
		
		public void scroll(String text) {
			driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" + ".scrollTextIntoView(\"" + text + "\")"));
		}
		
		public void scrollAndClick(String text) {
			driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" + ".scrollTextIntoView(\"" + text +"\")"));
			driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"" + text + "\")")).click();
		}
		
		public void switchContext(String context) {
			driver.context(context);
		}

}
