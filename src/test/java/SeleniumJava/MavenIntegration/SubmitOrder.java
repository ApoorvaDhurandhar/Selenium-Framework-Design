package SeleniumJava.MavenIntegration;



import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestComponents.BaseComponents;

public class SubmitOrder extends BaseComponents{
   
    @Test(dataProvider="getData", groups = {"Purchase"})
    
	public void SubmitOrderAgain(HashMap<String,String> input) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		//String findProduct= "ZARA COAT 3";
		String countryName="india";
		CataloguePage cataloguepageobj=loginpageobj.LoginPage(input.get("email"),input.get("password") );
	    List<WebElement> products = cataloguepageobj.getProductList();
	    cataloguepageobj.addProductToCart(input.get("productName"));
		cartPage cartpageobj = cataloguepageobj.goTOCart();
		Boolean isPresent = cartpageobj.productCheck(input.get("productName"));
		Assert.assertTrue(isPresent);
		checkoutPage checkoutpageobj= cartpageobj.selectItem();
		checkoutpageobj.selectCountry(countryName);
		checkoutpageobj.Submit();
		String fin="THANKYOU FOR THE ORDER.";
		Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), fin, fin);
		System.out.println(fin);
		}
    
    @DataProvider
    public Object[][] getData() throws IOException
    {
    	List<HashMap<String, String>>data = getDataFromJSon(System.getProperty("user.dir")+"\\src\\test\\java\\Data_json\\purchaseOrder.json");
    	
    	return new Object[][] {{data.get(0)},{data.get(1)}};
    }
}







/*public Object[][] getData() {
return new Object[][] {{"apd@gmail.com","@Daisy0123","ZARA COAT 3"},{"apdd@gmail.com","@Daisy01234","ADIDAS ORIGINAL"}};
}*/



/*HashMap<String,String> map = new HashMap<String,String>();
map.put("email", "apd@gmail.com");
map.put("password", "@Daisy0123");
map.put("productName", "ZARA COAT 3");

HashMap<String,String> map1 = new HashMap<String,String>();
map1.put("email", "apdd@gmail.com");
map1.put("password", "@Daisy01234");
map1.put("productName", "ADIDAS ORIGINAL");*/

