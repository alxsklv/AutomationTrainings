import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ecommerce_tc_1 extends base {

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = capabilities("emulator");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement name = driver.findElementByXPath("//android.widget.EditText[@resource-id='com.androidsample.generalstore:id/nameField']");
		name.sendKeys("Alexey");
		
		driver.hideKeyboard();		
		driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
		
		driver.findElementByClassName("android.widget.Spinner").click();
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		driver.findElementByXPath("//*[@text='Argentina']").click();
		
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		//
		//String message = driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
		//System.out.println(message);
		//Assert.assertEquals("Please enter your name", message);
		
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings \"));");
		
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));
        int amountOfProducts = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        for(int i=0; i<amountOfProducts; i++) {
        	String text = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
        	
        	if(text.equalsIgnoreCase("Jordan 6 Rings")) 
        	{
        		driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
        		break;
        	}
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        
        String productBasket = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        Assert.assertEquals("Jordan 6 Rings", productBasket);
        
        
       
	}

}
