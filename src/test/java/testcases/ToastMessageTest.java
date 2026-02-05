package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.BasePage;
import pageobjects.HomePage;
import testbase.BaseClass;

public class ToastMessageTest extends BaseClass {


	@Test( retryAnalyzer = utilities.RetryAnalyzer.class)
	public void verifyToastMessage() throws Exception {
		
		logger.info("********ToastMessageTest Started *********");
		try {

			
			BasePage bp = new BasePage(driver);
			logger.info("Scrolling to and selecting country: United States");
			bp.scrollAndClick("Argentina");
			logger.info("Clicking on Shop button");
			HomePage hp = new HomePage(driver);
			hp.clickShop();
			Assert.assertTrue(hp.verifyToastMessage());
			logger.info("Toast Message verified successfully");

		} catch (AssertionError e) {
			logger.error("Assertion failed: " + e.getMessage(), e);
			
			// Optionally rethrow to mark test as failed
	        throw e;
	        
	    } catch (Exception e) {
	        logger.error("Unexpected exception occurred: " + e.getMessage(), e);
	        throw e;

		} finally {
			logger.info("******** ToastMessageTest Completed ********");
		}

	}

}
