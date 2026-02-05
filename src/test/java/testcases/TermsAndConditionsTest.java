package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.CartPage;
import pageobjects.HomePage;
import pageobjects.ProductsPage;
import testbase.BaseClass;

public class TermsAndConditionsTest extends BaseClass{

	@Test( retryAnalyzer = utilities.RetryAnalyzer.class)
	public void verifyTermsAndConditions() throws Exception {

		logger.info("********TermsAndConditionsTest Started *********");

		try {

			HomePage hp = new HomePage(driver);
			logger.info("Scrolling to and selecting country: United States");
			hp.scrollAndClick("Argentina");
			logger.info("Entering name in Your Name field: Test");
			hp.enterName("Test");
			logger.info("Clicking on Shop button");
			hp.clickShop();
			logger.info("Navigating to Products page");
			logger.info("Scrolling to Jordan 6 rings");
			//Scroll to product "Jordan 6 rings"
			hp.scroll("Jordan 6 Rings");
			Thread.sleep(2000);
			ProductsPage pp = new ProductsPage(driver);
			//click add to cart for product "Jordan 6 Rings"
			logger.info("Clicking Add To Cart link for the selected product");
			pp.clickAddToCart();
			//Click on Add to Cart on top right corner
			logger.info("Clicking Add To Cart button in top right corner");
			pp.clickAddToCartButton();
			CartPage cp = new CartPage(driver);
			Thread.sleep(1000);
			logger.info("Performing long click on Terms of Conditions");
			cp.longClickTermsOfConditions();
			logger.info("Verifying alert title after long click on Terms and Conditions");
			Assert.assertTrue(cp.verifyAlertTitle());
			logger.info("Alert title verified successfully");

		} catch (AssertionError e) {
			logger.error("Assertion failed: " + e.getMessage(), e);
			// Optionally rethrow to mark test as failed
			throw e;   

		} catch (Exception e) {
			logger.error("Unexpected exception occurred: " + e.getMessage(), e);
			throw e;

		} finally {
			logger.info("******** TermsAndConditionsTest Completed ********");
		}
	}

}
