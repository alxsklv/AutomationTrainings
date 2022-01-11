package Academy;

import org.testng.annotations.Test;
import java.io.IOException;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import Resources.base;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Homepage extends base{
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][3];
		
		data[0][0] = "alex@mail.ru";
		data[0][1] = "test123";
		data[0][2] = "Restricted User";
		
		data[1][0] = "tom@mail.ru";
		data[1][1] = "14324324";
		data[1][2] = "Premium User";
		
		return data;
		
	}
	
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
	}
	
	
	@Test(dataProvider="getData")	
	public void basePageNavigation(String login, String password, String text) throws IOException, InterruptedException
	{
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();
		
		Thread.sleep(3000); 
		LoginPage t = new LoginPage(driver);
		t.enterEmail().sendKeys(login);
		t.enterPassword().sendKeys(password);
		//System.out.println(text);	
		log.info(text);
		t.clickLogin().click();
		
	}	
	
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
	
	

}



