import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ecommerce_tc_2 extends base {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
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
		
		List<AndroidElement> goods = driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart"));
		int size = goods.size();
		for(int i=0; i<size; i++) {
			goods.get(i).click();
		}
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(4000);
        
        double sumValue = 0;
        int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
        for (int i =0; i<count; i++) {
        	sumValue += getAmount(driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText());
        }
        
        System.out.println(sumValue);
        //String amount1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();     
        
        //String amount2 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();        
        
        //double sumValue = getAmount(amount1) + getAmount(amount2);
        
       String total = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
       total = total.substring(1);
       double totalValue = Double.parseDouble(total);
       
       Assert.assertEquals(sumValue, totalValue);   
       
       
       //MobileGestures
       WebElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));
       
       TouchAction t = new TouchAction(driver);
	   t.tap(tapOptions().withElement(element(checkbox))).perform();
	   //Thread.sleep(2000);
		
		WebElement terms = driver.findElementByXPath("//*[@text='Please read our terms of conditions']");		
		t.longPress(longPressOptions().withElement(element(terms)).withDuration(ofSeconds(2))).release().perform();
		
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(7000);


		Set<String> contextNames = driver.getContextHandles();
		
		for (String contextName : contextNames) {
		    System.out.println(contextName);
		}
		
		
		driver.findElement(By.xpath("//*[@value='Meer lezen']")).click();
		Thread.sleep(5000);
		WebElement agree = driver.findElement(By.xpath("//*[@value='Ik ga akkoord']"));
		agree.click();
		
		driver.context("WEBVIEW_com.androidsample.generalstore"); // set context to WEBVIEW_1
		driver.findElement(By.name("q")).sendKeys("hello");

		
		
		driver.context("NATIVE_APP");



		//driver.quit();

        
		
	}
	
	
	public static double getAmount(String value) 
	{
		value = value.substring(1);
		double amount2value = Double.parseDouble(value);
		return amount2value;
	}	
	

}
