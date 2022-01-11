package TestPackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class day3 {
	
	
	@Test(dataProvider="getData")
	public void WebLogin(String user, String password)
	{
		System.out.println("Credentials 3 times");
		System.out.println(user);
		System.out.println(password);
	}
	
	@Test(groups= {"Smoke"})
	public void MobileLogin() 
	{
		//Appium
	}
	
	@Test(dependsOnMethods= {"WebLogin"})
	public void MobileLogout() 
	{
		//Appium
	}
	
	@Test(timeOut=4000)
	public void APITestLoan() 
	{
		//Appium
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//1st set of username and pwd
		//2nd set of username and pwd
		//3rd set of username and pwd
		
		Object[][] data = new Object[3][2];
		//1st set
		data[0][0] = "Alex";
		data[0][1] = "1234";
		
		//2nd set
		data[1][0] = "Tom";
		data[1][1] = "567";
		
		//3rd set
		data[2][0] = "Nike";
		data[2][1] = "8910";
		
		return data;
	}
	


}
