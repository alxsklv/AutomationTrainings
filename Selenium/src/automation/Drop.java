package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Drop {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
//		Actions a = new Actions(driver);
		
		driver.get("https://the-internet.herokuapp.com/");
		
		WebElement linkToNestedFrames = driver.findElement(By.xpath("//a[@href='/nested_frames']"));
		linkToNestedFrames.click();		

		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='/frame_top']")));		
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='/frame_middle']")));
		System.out.println(driver.findElement(By.cssSelector("#content")).getText());
	}
}
//driver.switchTo().frame(driver.findElement(By.className("demo-frame")));		
//	WebElement dragItem = driver.findElement(By.cssSelector("#draggable"));
//	WebElement destinationFrame = driver.findElement(By.cssSelector("#droppable"));
//	a.dragAndDrop(dragItem, destinationFrame).build().perform();