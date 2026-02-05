package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductsPage extends BasePage{

	public ProductsPage(AndroidDriver driver)  {
		super(driver);
	}

	
	//Locators
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/toolbar_title")
	public WebElement toolbarTitle;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productName")
	public List<WebElement> listOfProducts;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart")
	public List<WebElement> listOfAddToCartButtons;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement addToCartbutton;
	
	//Action methods
	
	public boolean verifyProductsPage() {
		return toolbarTitle.getText().equals("Products");
	}
	
	public void clickAddToCart() {
		
		for(int i=0; i<listOfProducts.size(); i++)
		{
			String productName = listOfProducts.get(i).getText();
			if(productName.equalsIgnoreCase("Jordan 6 Rings"))
					listOfAddToCartButtons.get(i).click();
		}
	}
	
	public void clickAddToCartButton() {
		addToCartbutton.click();
	}
	
}
