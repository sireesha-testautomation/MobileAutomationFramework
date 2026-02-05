package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.BasePage;
import pageobjects.HomePage;
import pageobjects.ProductsPage;
import testbase.BaseClass;

public class ShopSelectingCountryTest  extends BaseClass{

	@Test( retryAnalyzer = utilities.RetryAnalyzer.class)
	public void verifyProductsPage() throws Exception{

		logger.info("********ShopSelectingCountryTest Started *********");

		try {

			//Select country from dropdown
			BasePage bp = new BasePage(driver);
			logger.info("Scrolling to and selecting country: United States");
			bp.scrollAndClick("Argentina");
			logger.info("Entering name in Your Name field: Test");
			HomePage hp = new HomePage(driver);
			hp.enterName("Test");
			logger.info("Clicking on Shop button");
			hp.clickShop();
			logger.info("Navigating to Products page");

			ProductsPage pp = new ProductsPage(driver);
			Thread.sleep(2000);
			logger.info("Verifying Products Page contains 'Products'");
			Assert.assertTrue(pp.verifyProductsPage());
			logger.info("Products Page displayed successfully");

		} catch (AssertionError e) {
			logger.error("Assertion failed: " + e.getMessage(), e);
			// Optionally rethrow to mark test as failed
	        throw e;
	        
	    } catch (Exception e) {
	        logger.error("Unexpected exception occurred: " + e.getMessage(), e);
	        throw e;

		} finally {
			logger.info("******** ShopSelectingCountryTest Completed ********");
		}
	}



}