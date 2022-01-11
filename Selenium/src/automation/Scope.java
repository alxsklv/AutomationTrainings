package automation;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//System.out.println(driver.findElements(By.tagName("a")).size()); 
		
		WebElement footerDriver = driver.findElement(By.cssSelector("#gf-BIG"));
		//System.out.println(footerDriver.findElements(By.tagName("a")).size()); 
		
		WebElement columnDriver = footerDriver.findElement(By.xpath("//tbody/tr/td[1]/ul"));
		int firstColumnItemsSize = columnDriver.findElements(By.tagName("a")).size();
		
		for (int i=1; i < firstColumnItemsSize; i++) {
			String clickOnLink = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);			
		}
		Thread.sleep(5000L);
		
		Set<String> tabs = driver.getWindowHandles();
		Iterator<String> it = tabs.iterator();
		
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		
		
	}

}
