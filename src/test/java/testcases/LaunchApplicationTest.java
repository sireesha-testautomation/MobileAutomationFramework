package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import testbase.BaseClass;

public class LaunchApplicationTest extends BaseClass {

	@Test( retryAnalyzer = utilities.RetryAnalyzer.class)
	public void verifyLaunchApplicationTest() throws Exception{

		logger.info("********LaunchApplicationTest Started *********");

		try {
			
			HomePage hp = new HomePage(driver);

			//Verify application is launched by checking the presence of field "Your Name"
			Assert.assertTrue(hp.verifyfieldName());
			logger.info("Application launched successfully");

		} catch (AssertionError e) {
			logger.error("Assertion failed: " + e.getMessage(), e);
			// Optionally rethrow to mark test as failed
	        throw e;
	        
	    } catch (Exception e) {
	        logger.error("Unexpected exception occurred: " + e.getMessage(), e);
	        throw e;
	        
		} finally {
			logger.info("******** LaunchApplicationTest Completed ********");
		}

	}

}
