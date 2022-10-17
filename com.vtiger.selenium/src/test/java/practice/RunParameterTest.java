package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RunParameterTest {
	
	@Test
	public void bC()
	{
		WebDriver driver;
		String BROWSER = System.getProperty("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
			
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}

		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}

		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}

		else 
		{
			driver=new ChromeDriver();
		}
		String Url=System.getProperty("url");
		String Un = System.getProperty("un");
		String Pw = System.getProperty("pw");
		
		driver.get(Url);
		driver.findElement(By.name("user_name")).sendKeys(Un);
		driver.findElement(By.name("user_password")).sendKeys(Pw);
		driver.findElement(By.id("submitButton")).click();		
	}

}
