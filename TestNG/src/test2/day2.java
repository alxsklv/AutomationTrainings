package test2;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class day2 {
	@Test
	public void Demo()
	{
		System.out.println("Hello");
	}
	
	@Test
	public void SecondTest()
	{
		System.out.println("Alex");
	}
	
	@BeforeTest
	public void prerequiste()
	{
		System.out.println("First execution");
	}


}
