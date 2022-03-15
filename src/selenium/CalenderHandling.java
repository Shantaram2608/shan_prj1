package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalenderHandling {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Lenovo/Desktop/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("http://demo.automationtesting.in/Datepicker.html");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(By.id("datepicker2")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//select[@title='Change the month']")).click();
		WebElement we1 =driver.findElement(By.xpath("//select[@title='Change the month']"));
		Select sc1 = new Select(we1);
		Thread.sleep(5000);
		sc1.selectByIndex(7);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//select[@title='Change the year']")).click();
		Thread.sleep(3000);
	    driver.findElement(By.xpath("//option[14]")).click();
	    Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Select Friday, Aug 9, 2024']")).click();
		driver.close();
		System.out.println("date selected");
	}

}
