package SeleniumJava.MavenIntegration;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.abstractComponents;

public class CataloguePage extends abstractComponents {
	WebDriver driver;
	public CataloguePage(WebDriver driver)
	{   super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (css = ".mb-3")
	List<WebElement> products;
	
	@FindBy(css = ".ng-animating")
	WebElement spinner;

	
	By productLable = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList() {
		waitForElementvisiblity(productLable);
		return products;
	}	
		
	
	public WebElement getProductByName(String findProduct)
	{
		
		WebElement prod = getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(findProduct)).findFirst().orElse(null);
		return prod;
		
		
	}
	
	public void addProductToCart(String productName) throws InterruptedException
	{
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementvisiblity(toastMessage);
		waitForElementinvisiblity(spinner);


	
}


	}
