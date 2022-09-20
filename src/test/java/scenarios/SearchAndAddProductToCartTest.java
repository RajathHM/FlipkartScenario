package scenarios;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchAndAddProductToCartTest {

	@Test
	public void TestCase01() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://flipkart.com");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("winter heater");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//div[@data-id='ROHG9R5RWDHK9V2T']//div//a")).click();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentid=it.next();
		String childId=it.next();
		driver.switchTo().window(childId);
		String str1 = driver.findElement(By.xpath("//span[@class='B_NuCI']")).getText();
		driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
		String str2 = driver.findElement(By.xpath("//a[@class='_2Kn22P gBNbID']")).getText();
		Assert.assertEquals(str1,str2);
		driver.close();
		
		}

}
