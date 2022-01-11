package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.*;



public class AssigmentSeven {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		WebElement checkBoxTwo = driver.findElement(By.cssSelector("#checkBoxOption2"));
		checkBoxTwo.click();		
		String selectedOptionName = checkBoxTwo.getAttribute("value");
		
		Select se = new Select(driver.findElement(By.xpath("//select[@id='dropdown-class-example']")));
	         se.selectByValue(selectedOptionName);
	         String dropSelectedText = se.getFirstSelectedOption().getText();
	         
	    WebElement nameField = driver.findElement(By.cssSelector("#name"));
	    nameField.sendKeys(dropSelectedText);
	    
	    driver.findElement(By.cssSelector("#alertbtn")).click();
    
	    
	    String[] alertMessage = driver.switchTo().alert().getText().split(" ");
	    String clearedMessageValue = alertMessage[1].replace(",", "").trim();

	    
	    if (clearedMessageValue.equals(dropSelectedText)) {
	    	System.out.println("Success");
	    }
	    else {
	    	System.out.println("Test Failed");
	    }		

	}

}
