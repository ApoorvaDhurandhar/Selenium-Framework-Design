package TestComponents;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import SeleniumJava.MavenIntegration.LoginPageLocators;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseComponents {
	public static WebDriver driver;
	public static LoginPageLocators loginpageobj;
	public static WebDriver InitializeDriver() throws IOException
	{   Properties prop = new Properties();
	    FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\GlobalData.properties");
	    prop.load(fis);
	     //String BrowserName = System.getProperty("browser")!= null? System.getProperty("browser"):prop.getProperty("browser");
	    String BrowserName=prop.getProperty("browser");
	    if (BrowserName.equalsIgnoreCase("chrome"))
	    {
	    	WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
	    }
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
	}
	
	
	@BeforeMethod
	public static  LoginPageLocators LaunchDriver() throws IOException
	{
		driver = InitializeDriver();
		 loginpageobj = new LoginPageLocators(driver);
		 loginpageobj.GoTo();
		 return loginpageobj;
	}
	
	
	
	public List<HashMap<String,String>> getDataFromJSon(String fileName) throws IOException
	{
	String JsonContent =	FileUtils.readFileToString(new File(fileName),StandardCharsets.UTF_8);
	
    
	//string to hashmap
	
	ObjectMapper mapper = new ObjectMapper();
	  List<HashMap<String, String>> data = mapper.readValue(JsonContent, new TypeReference<List<HashMap<String, String>>>() {});
	return data;

    }
	
	
	
	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
	}
	
	
	
	@AfterMethod
	public void Teardown()
	{
		driver.close();
	}

}
