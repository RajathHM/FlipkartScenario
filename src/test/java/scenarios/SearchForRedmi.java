package scenarios;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchForRedmi {

	@Test
	public void TestCase02() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://flipkart.com");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("redmi");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		List<WebElement> products = driver.findElements(By.xpath("//li[contains(text(),'4 GB RAM')]/../../../div[1]"));
		for(WebElement ele:products)
		{
			System.out.println(ele.getText());
		}
		
	}

}
