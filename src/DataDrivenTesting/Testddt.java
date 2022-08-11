package DataDrivenTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Testddt {
	WebDriver driver;
	@BeforeMethod
	  public void setup() {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver\\chromedriver.exe"); 
		 driver = new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.manage().deleteAllCookies();
	     driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	     driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	}
	
	@Test(dataProvider="LoginData")
	public void loginTest(String username,String password,String res)
	{
	driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
	WebElement	email=driver.findElement(By.xpath("//*[@type='email']"));
	email.clear();
	email.sendKeys(username);
	
    WebElement pwd=driver.findElement(By.xpath("//*[@type='password']"));
    pwd.clear();
    pwd.sendKeys(password);
    
    driver.findElement(By.xpath("//*[@type='submit']")).click();
    String Exp_title ="https://admin-demo.nopcommerce.com/admin/";
    String act_title = driver.getTitle();
     if(res.equals("valid"))
     {
    	if(res.equals(act_title))
    	{
    		driver.findElement(By.linkText("Logout")).click();
    		Assert.assertTrue(true);
    	}
    	else
    	{
    		Assert.assertFalse(false);
    	}
     }
    	else if(res.equals("invalid")) {
    		if(Exp_title.equals(act_title))
    		{
    			driver.findElement(By.linkText("Logout")).click();
    			Assert.assertTrue(true);
    		}
    		else
    		{
    			Assert.assertFalse(false);
    		}
    	}



	}
	
	@DataProvider(name="LoginData")
	 String[][]getdata(){
			
			String logindata[][] = {
					
					{"admin@yourstore.com","admin","valid"},
					{"admn@yourstore.com","admin","invalid"},
					{"admin@yourstore.com","amin","invalid"},
					{"admin@yourstoe.com","adminw","invalid"}

					};
			return logindata;
		}
	

}
