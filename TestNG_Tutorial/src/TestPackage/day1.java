package TestPackage;

import org.testng.annotations.Test;

public class day1 {

	@Test
	public void Demo() 
	{
		
		System.out.println("hello");

	}
	
	@Test(groups= {"Smoke"})
	public void SecondTest()
	{
		System.out.println("Test 2");
	}

}
