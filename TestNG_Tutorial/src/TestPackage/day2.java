package TestPackage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day2 {
	
	
	@AfterTest
	public void EndTest() {
		System.out.println("Always at the end");
	}

	@Test(groups= {"Smoke"})
	public void Demo3() 
	{
		
		System.out.println("hello demo");

	}
	
	@Parameters({"URL"})
	@BeforeTest
	public void prerequisites(String urlBrowser)
	{
		System.out.println("First thing to execute - clean all data from DB");
		System.out.println(urlBrowser);
	}
	


}