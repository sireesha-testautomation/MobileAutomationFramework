package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MobileGestures {
	
	private  AndroidDriver driver;

	public MobileGestures(AndroidDriver driver) {

      this.driver = driver;
	}

	public  void longClick(WebElement element) {
	JavascriptExecutor je = (JavascriptExecutor)driver;
	je.executeScript("mobile:longClickGesture",ImmutableMap.of("elementId",((RemoteWebElement) element).getId()));
	}
	
	// Press Android back button
		public void goBack() {
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}
}
