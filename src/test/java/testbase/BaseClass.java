package testbase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseClass {

	protected AndroidDriver driver;
	public Logger logger = LogManager.getLogger(this.getClass());
	Properties p;

	@BeforeClass
	@Parameters({"deviceName", "port"})
	public void setup(String deviceName, String port) throws URISyntaxException, IOException {

		logger.info("********* Test Setup Started *********");

		try {
			// Load configuration properties
			p = new Properties();
			logger.info("Loading configuration properties file");
			FileReader filereader = new FileReader(".//src/test/resources/config.properties");
			p.load(filereader);
			logger.info("Configuration properties loaded successfully");
		}
		catch(FileNotFoundException e){
			logger.error("config.properties file not found", e);
		}
		//Configure Android session
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(deviceName);
		options.setApp(p.getProperty("appUrl"));
		options.setChromedriverExecutable(System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");

		// Initializing the driver
		logger.info("Initializing the driver");
		URL appiumServerUrl = new URI("http://127.0.0.1:" + port).toURL();
		driver = new AndroidDriver(appiumServerUrl, options);
		DriverFactory.setDriver(driver);

		//Global wait
		logger.info("Waiting for application home page to load");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	public AppiumDriver getDriver() {
		return DriverFactory.getDriver();
	}

	@AfterClass
	public void tearDown() {

		//driver.quit();
		logger.info("Closing the application and quitting WebDriver ");
		logger.info("******** Test Execution Finished **********");

	}

	public String captureScreen(String tname) throws IOException {

		logger.info("Starting screenshot capture for test: {}", tname);
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		logger.debug("Generated timestamp for screenshot: {}", timeStamp);

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		logger.info("Screenshot captured successfully in temporary location");
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);

		boolean isMoved = sourceFile.renameTo(targetFile);

		if (isMoved) {
			logger.info("Screenshot saved successfully at: {}", targetFilePath);
		} else {
			logger.error("Failed to save screenshot at: {}", targetFilePath);
		}

		return targetFilePath;

	}
}
