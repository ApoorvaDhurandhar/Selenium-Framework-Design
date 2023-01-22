package SeleniumJava.MavenIntegration;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.abstractComponents;

public class LoginPageLocators extends abstractComponents {
	WebDriver driver;
	public LoginPageLocators (WebDriver driver)
	{   super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id = "userEmail")
	WebElement userId;
	
	@FindBy(id ="userPassword" )
	WebElement Password;
	
	@FindBy (id = "login")
	WebElement LoginButton;
	
	@FindBy(css= ".ng-star-inserted")
	WebElement errorMessage;



	public CataloguePage LoginPage(String Userid, String Pass)
	{
		
		userId.sendKeys(Userid);
		Password.sendKeys(Pass);
		LoginButton.click();
		CataloguePage cataloguepageobj = new CataloguePage(driver);
		return cataloguepageobj;
	}
	
	public void GoTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	public String getErrorMessage()
	{   waitForWebElementvisiblity(errorMessage);
		return errorMessage.getText();
	}

}

