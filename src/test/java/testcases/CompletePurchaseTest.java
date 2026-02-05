package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.BasePage;
import pageobjects.CartPage;
import pageobjects.HomePage;
import pageobjects.ProductsPage;
import pageobjects.PurchasePage;
import testbase.BaseClass;
import utilities.MobileGestures;

public class CompletePurchaseTest extends BaseClass {
	
	@Test( retryAnalyzer = utilities.RetryAnalyzer.class)
	public void verifyCompletePurchase() throws Exception {
		
		logger.info("********CompletePurchase Started *********");

		try {

			BasePage bp = new BasePage(driver);
			logger.info("Scrolling to and selecting country: United States");
			bp.scrollAndClick("Argentina");
			
			HomePage hp = new HomePage(driver);
			logger.info("Entering name in Your Name field: Test");
			hp.enterName("Test");
			
			logger.info("Clicking on Shop button");
			hp.clickShop();
			logger.info("Navigating to Products page");
			ProductsPage pp = new ProductsPage(driver);
			
			logger.info("Scrolling to Jordan 6 rings");
			//Scroll to product "Jordan 6 rings"
			hp.scroll("Jordan 6 Rings");
			Thread.sleep(2000);
			
			//click add to cart for product "Jordan 6 Rings"
			logger.info("Clicking Add To Cart link for the selected product");
			pp.clickAddToCart();
			
			//Click on Add to Cart on top right corner
			logger.info("Clicking Add To Cart button in top right corner");
			pp.clickAddToCartButton();
			logger.info("Navigating to Cart page");
			CartPage cp = new CartPage(driver);
			Thread.sleep(1000);
			
			cp.clickCheckbox();
			logger.info("Clicked terms and conditions checkbox");
			
			cp.clickCompletePurchase();
			logger.info("Clicked Complete Purchase button");
			PurchasePage ppage = new PurchasePage(driver);
			logger.info("Navigated to Purchase Page");
			
			//ppage.explicitWait();
			//Thread.sleep(4000);
			ppage.waitForWebView();
			logger.info("Waited for Purchase Page elements to load");
			bp.switchContext("WEBVIEW_com.androidsample.generalstore");
			
			logger.info("Entering text into Purchase Page search box: CloudBerry Bootcamp");
			ppage.enterTextAndEnter("CloudBerry Bootcamp");
			logger.info("Text entered and Enter key pressed on Purchase Page");
			
			logger.info("Initializing MobileGestures utility class");
			MobileGestures mb = new MobileGestures(driver);
			logger.info("Navigating back to previous screen");
			mb.goBack();
			
			logger.info("Switching context to NATIVE_APP");
			bp.switchContext("NATIVE_APP");
			logger.info("Verifying Home Page is displayed by verifying the toolbar title");
			Assert.assertTrue(hp.verifyHomePage());
			logger.info("'Your Name' label on homepage verified successfully");

		} catch (AssertionError e) {
			logger.error("Assertion failed: " + e.getMessage(), e);
			// Optionally rethrow to mark test as failed
			throw e;
		} catch (Exception e) {
			logger.error("Unexpected exception occurred: " + e.getMessage(), e);
			throw e;

		} finally {
			logger.info("******** CompletePurchaseTest Completed ********");
		}
	}

}
