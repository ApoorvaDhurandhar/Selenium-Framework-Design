package SeleniumJava.MavenIntegration;



import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import AbstractComponents.abstractComponents;
import SeleniumJava.MavenIntegration.CataloguePage;
import SeleniumJava.MavenIntegration.cartPage;
import TestComponents.BaseComponents;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidation extends BaseComponents{
   
   
   @Test
    
	public void Idvalidation() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
	
		loginpageobj.LoginPage("apd@gmail.com", "@@Daisy0123");
		Assert.assertEquals("Incorrect email password.", loginpageobj.getErrorMessage());
		}
    
    
    @Test
    
   	public void ProductValidation() throws InterruptedException, IOException {
   		// TODO Auto-generated method stub
   		
   		String findProduct= "ZARA COAT 3";
   		String countryName="india";
   		CataloguePage cataloguepageobj=loginpageobj.LoginPage("apd@gmail.com", "@Daisy0123");
   	    List<WebElement> products = cataloguepageobj.getProductList();
   	    cataloguepageobj.addProductToCart(findProduct);
   		cartPage cartpageobj = cataloguepageobj.goTOCart();
   		Boolean isPresent = cartpageobj.productCheck("ZARA COAT 33");
   		Assert.assertFalse(isPresent);
   		
   		}
	}


