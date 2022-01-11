package Academy;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import Resources.base;
import pageObjects.LandingPage;
import org.apache.logging.log4j.LogManager;
public class validateTitle extends base{
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));
		log.info("Navigate to homepage");
	}
	

	@Test
	public void textCheck() throws IOException, InterruptedException
	{		
		LandingPage l = new LandingPage(driver);
		//Compare the text from browser with actual value
		Assert.assertEquals(l.getTitle().getText().toLowerCase(), "featured courses");
		log.info("Successfully validated text message");

	}	
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
	

}



