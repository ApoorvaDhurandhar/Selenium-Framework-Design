package AbstractComponents;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumJava.MavenIntegration.cartPage;

public class abstractComponents {
	WebDriver driver;
	public abstractComponents(WebDriver driver)
	{   
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	//By toastContainer = By.cssSelector("#toast-container");
	//By ngAnimating = By.cssSelector(".ng-animating");
	@FindBy(css = "button[routerlink*='cart']")
	WebElement cartbutton;
	
	public void waitForElementvisiblity(By toastMessage)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(toastMessage));
	}
	
	public void waitForWebElementvisiblity(WebElement errorMessage)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(1));
		wait.until(ExpectedConditions.visibilityOfAllElements(errorMessage));
	}

	public void waitForElementinvisiblity(WebElement spinner)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf( spinner));
	}
	
	public cartPage goTOCart()
	{
		cartbutton.click();
		cartPage cartpageobj = new cartPage(driver);
		return cartpageobj;
	}
}

