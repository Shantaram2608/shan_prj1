package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalenderHandling1 {
	
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Lenovo/Desktop/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://testautomationpractice.blogspot.com");
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.findElement(By.id("datepicker")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("ui-datepicker-div"))));
		
		selectDate("1","February","2024");
		driver.close();
	}
	
	//********************************************************************************
	public static String[] getMonthYear(String monthYearVal)
	{
		return monthYearVal.split(" ");
	}
	
	//************************************************************************************
	
	public static void selectDate(String exDate,String exMonth,String exYear)
	{
		if(exMonth.equals("February") && Integer.parseInt(exDate)>29)
		{
			System.out.println("Wrong Date : "+exMonth+" : "+exDate);
			return;
		}
		if(Integer.parseInt(exDate)>31)
		{
			System.out.println("Wrong Date : "+exMonth+" : "+exDate);
			return;
		}
		
		String monthYearVal = driver.findElement(By.className("ui-datepicker-title")).getText();
		
		
		while(!(getMonthYear(monthYearVal)[0].equals(exMonth) && getMonthYear(monthYearVal)[1].equals(exYear)))
		{
			System.out.println(monthYearVal);
			driver.findElement(By.xpath("/html/body/div[5]/div/a[2]")).click();
		    monthYearVal = driver.findElement(By.className("ui-datepicker-title")).getText();
		}
		System.out.println(monthYearVal);
		System.out.println("Selected Date :->"+exDate+"/"+exMonth+"/"+exYear);
		driver.findElement(By.xpath("//a[text()='"+exDate+"']")).click();
		
	}

}
