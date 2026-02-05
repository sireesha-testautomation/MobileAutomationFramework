package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	
	//Logs retries, warnings, and debugging info for failed tests.
	private static final Logger log = LogManager.getLogger(RetryAnalyzer.class);
	
	private int retryCount = 0;  //tracks how many times the test has been retried.
	private static final int maxRetryCount = 2; //maximum number of retries
	
	 public boolean retry(ITestResult result) {
	        if (retryCount < maxRetryCount) {
	            log.warn("Retrying test '{}' ({} of {})", result.getName(), retryCount + 1, maxRetryCount);//Logs each retry attempt at WARN level.
	            retryCount++;
	            return true;
	        }
	        return false;
	    }
	}


