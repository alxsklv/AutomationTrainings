package Academy;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.Assert;
import Resources.base;
import pageObjects.LandingPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class checkNavigationBar extends base{
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}	

	@Test
	public void navigationCheck() throws IOException, InterruptedException
	{
		LandingPage l = new LandingPage(driver);

		Assert.assertTrue(l.getNavBar().isDisplayed());	
		log.info("Navigation bar is displayed");
		
	}	
	
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
	
	

}



