package datapro;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Offlineweb2 {
	WebDriver driver;
	
  @Test(dataProvider="amitdata")
  public void logintooffline(String username,String password) throws InterruptedException {
	  
	  driver=new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  driver.get("file:///I:/Selenium%20Software/Offline%20Website/index.html");
	  driver.findElement(By.id("email")).sendKeys(username);
	  driver.findElement(By.id("password")).sendKeys(password);
	  driver.findElement(By.xpath(".//*[@id='form']/div[3]/div/button")).click();
	          Thread.sleep(5000);
	         // System.out.println(driver.getTitle());
	          //driver.quit();
	          Assert.assertTrue(driver.getTitle().contains("Dashboard"),"user not able to login");
	           System.out.println("page is verfied-user able to login");
	  	  
  }
  @AfterMethod
  public void shutdown()
  {
	  
	  driver.quit();
  }
  
  @DataProvider(name="amitdata")
  public Object[][] logindata()
  {
	  Object[][] data=new Object[3][2];
	  data[0][0]="amit";
	  data[0][1]="xyz";
	  
	  data[1][0]="amit";
	  data[1][1]="xyz";
	  
	  data[2][0]="kiran@gmail.com";
	  data[2][1]="123456";
	  
	  
	  
	  
	  return data;
	  
	  
	  
	  
	  
	  
  }
  }
  

