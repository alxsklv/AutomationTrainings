package automation;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaStreams {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		WebElement tableOnly = driver.findElement(By.cssSelector(".table-bordered"));	
	//	tableOnly.findElement(By.xpath("//thead/tr[1]/th[1]")).click();
		
		List<WebElement> valuesFromList = tableOnly.findElements(By.xpath("//tbody/tr/td[1]"));		
		
		List<String> convertedList = valuesFromList.stream().map(WebElement::getText).collect(Collectors.toList());
		//List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());
		
		List<String> sortedList = convertedList.stream()				
				.sorted()
				.collect(Collectors.toList());
		
		List<String> convertedListBySite = valuesFromList.stream().map(WebElement::getText).collect(Collectors.toList());

		try{
		    Assert.assertEquals(sortedList, convertedListBySite);
		    System.out.println("Equal lists");
		}catch(Throwable e){
		    System.err.println("Lists are not equal. "+e.getMessage());
		}
	}

}
