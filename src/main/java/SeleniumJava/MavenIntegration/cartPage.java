package SeleniumJava.MavenIntegration;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.abstractComponents;

public class cartPage extends abstractComponents {
    WebDriver driver;
	public cartPage(WebDriver driver)
	{   super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(css = ".totalRow button")
	WebElement selectButton;
	
	public Boolean productCheck(String findProduct)
	{
		Boolean isPresent= cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(findProduct));
        return isPresent;
	}
	
	public checkoutPage selectItem()
	{
		selectButton.click();
		checkoutPage checkoutpageobj = new checkoutPage(driver);
		return checkoutpageobj;
	}
}
