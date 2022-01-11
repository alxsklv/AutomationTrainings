package automation;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		WebElement tableOnly = driver.findElement(By.cssSelector(".table-bordered"));
		List<String>price;
		
		do {
			List<WebElement> valuesFromList = tableOnly.findElements(By.xpath("//tbody/tr/td[1]"));	
			price  =valuesFromList.stream().filter(s->s.getText().contains("Apple")). 
					map(s -> getPriceVeggie(s)).collect(Collectors.toList());
			
			price.forEach(a->System.out.println(a));
		
		if(price.size()<1) {
			driver.findElement(By.cssSelector("[aria-label=\"Next\"]")).click();
		}
		} while(price.size()<1);
	}

	private static String getPriceVeggie(WebElement s) {
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

}
