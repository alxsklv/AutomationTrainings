package automation;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Test2 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		Actions a = new Actions(driver);
		
		driver.get("https://the-internet.herokuapp.com/windows");
		
		WebElement clickHere = driver.findElement(By.xpath("//a[@href='/windows/new']"));
		clickHere.click();
		
		Set<String> windowsAmount = driver.getWindowHandles();
		Iterator<String>it = windowsAmount.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		
		WebElement resultText = driver.findElement(By.xpath("//div[@class='example']/h3[1]"));
		System.out.println(resultText.getText());
		
		driver.switchTo().window(parentId);
		
		WebElement parentText = driver.findElement(By.xpath("//div[@class='example']/h3[1]"));
		System.out.println(parentText.getText());
	}

}
