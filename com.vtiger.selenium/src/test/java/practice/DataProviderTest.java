package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest
{

	@Test(dataProvider="dataProvider_test")
	public void contactDetails(String lastname,String phno,String email) throws InterruptedException
	{
		String key="webdriver.chrome.driver";
		String value="C:\\Users\\USER\\eclipse-workspace\\com.vtiger.selenium\\src\\main\\resources\\chromedriver.exe";
		System.setProperty(key,value);
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.id("mobile")).sendKeys(phno);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		driver.quit();		
	}
	@DataProvider
	public Object[][] dataProvider_test()
	{
		Object[][] objArr=new Object[3][3];
		objArr[0][0]="Sathish";
		objArr[0][1]="876468383";
		objArr[0][2]="sati123@gamail.com";
		
		objArr[1][0]="Mahesh";
		objArr[1][1]="937749739";
		objArr[1][2]="Mahi123@gmail.com";

		objArr[2][0]="Santosh";
		objArr[2][1]="8379937390";
		objArr[2][2]="san934@gmail.com";
		return objArr;
	}

}