package selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Basic {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("1");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		System.out.println("2");
		WebDriver driver = new ChromeDriver();

		System.out.println("3");
		driver.get("file:/E:/Selenium%20Setup/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		System.out.println("4");
		driver.manage().window().maximize();

		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
	    driver.findElement(By.xpath("//*[@id=\"email_error\"]")).getText();
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")).click();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Shantaram");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"mobile\"]")).sendKeys("9822336456");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc@gamil.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='course']")).sendKeys("java");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='Male']")).click();
		
		//***********Code for printing of Dropdown List on console************
		
		Select dropdown = new Select(driver.findElement(By.xpath("//div[@class='col-sm-4']//select")));
		List<WebElement> wb = dropdown.getOptions();
		int itemCount = wb.size();
		for(int i = 0; i < itemCount; i++)
		{
		    System.out.println(wb.get(i).getText());
		}
		
		
		dropdown.selectByValue("Maharashtra");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Pass@123");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		driver.findElement(By.xpath("//input[@placeholder='FriendMobile' ]")).sendKeys("9988774455");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		driver.switchTo().alert().accept(); 
		driver.navigate().back();
		driver.findElement(By.xpath("//a[@href='operators.html']")).click();
		driver.findElement(By.xpath("//a[@href='links.html']")).click();
		driver.findElement(By.xpath("//a[@href='downloads.html']")).click();
		driver.findElement(By.xpath("//a[@href='logout.html']")).click();
		System.out.println("Log Out Successfully"); 

	}

}
