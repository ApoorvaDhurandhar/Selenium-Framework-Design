package SeleniumJava.MavenIntegration;



import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumJava.MavenIntegration.CataloguePage;
import SeleniumJava.MavenIntegration.cartPage;
import SeleniumJava.MavenIntegration.checkoutPage;
import TestComponents.BaseComponents;

public class StandAloneTest extends BaseComponents{
   
    @Test
    
	public void SubmitOrder() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		String findProduct= "ZARA COAT 3";
		String countryName="india";
		CataloguePage cataloguepageobj=loginpageobj.LoginPage("apd@gmail.com", "@Daisy0123");
	    List<WebElement> products = cataloguepageobj.getProductList();
	    cataloguepageobj.addProductToCart(findProduct);
		cartPage cartpageobj = cataloguepageobj.goTOCart();
		Boolean isPresent = cartpageobj.productCheck(findProduct);
		Assert.assertTrue(isPresent);
		checkoutPage checkoutpageobj= cartpageobj.selectItem();
		checkoutpageobj.selectCountry(countryName);
		checkoutpageobj.Submit();
		String fin="THANKYOU FOR THE ORDER.";
		Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), fin, fin);
		System.out.println(fin);
		}
	}


