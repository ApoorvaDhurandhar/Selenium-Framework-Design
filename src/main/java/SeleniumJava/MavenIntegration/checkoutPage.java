package SeleniumJava.MavenIntegration;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.abstractComponents;

public class checkoutPage extends abstractComponents{
	    WebDriver driver;
		public checkoutPage(WebDriver driver)
		{   super(driver);
			this.driver = driver;
			PageFactory.initElements(driver,this);
		}
		@FindBy(css = ".form-group input")
		WebElement countryName;
		
		@FindBy(css = ".ta-item")
		List<WebElement> countryNames;
		
		@FindBy(css =".action__submit")
		WebElement submitButton;
		
		
		public void selectCountry(String CountryName)
		{
			countryName.sendKeys(CountryName);
			for(int i =0;i<countryNames.size();i++)
			{
				if(countryNames.get(i).getText().equalsIgnoreCase(CountryName))
				{
					countryNames.get(i).click();
					
				}
			}
		}
		
	public void Submit()
	{
		submitButton.click();
		
	}

}
