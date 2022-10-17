package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ContactsModuleDataProviderTest {
	
	@Test
	public void contactDetails(String name, String phno, String email)
	{
		String key="webdriver.chrome.driver";
		String value="C:\\Users\\USER\\eclipse-workspace\\com.vtiger.selenium\\src\\main\\resources\\chromedriver.exe";
		System.setProperty(key,value);
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		System.out.printn("Good morning");
		driver.findElement(By.id("submitButton")).click();
	}

}
