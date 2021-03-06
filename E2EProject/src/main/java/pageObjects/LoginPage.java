package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	By email = By.cssSelector("#user_email");
	By password = By.cssSelector("#user_password");
	By login = By.cssSelector("[value='Log In']");
	
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
	}
	

	public WebElement enterEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement enterPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement clickLogin()
	{
		return driver.findElement(login);
	}

}
