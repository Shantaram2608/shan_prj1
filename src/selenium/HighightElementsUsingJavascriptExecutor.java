package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HighightElementsUsingJavascriptExecutor {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Lenovo/Desktop/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:/E:/Selenium%20Setup/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		WebElement loginBtn = driver.findElement(By.xpath("//button"));
		//flash(loginBtn,driver);
		//drawBorder(loginBtn,driver);
	//	createAlert(driver, "There is an issue in Login button");
		clickElementByJS(loginBtn, driver);
		refreshBrowserByJS(driver);
		System.out.println("refresh success");
		System.out.println(getTitleByJS(driver));
		System.out.println(getPageInnerTextByJS(driver));
		
		driver.close();
	}
	
	//*******************flash method*****************
	public static void flash(WebElement element,WebDriver driver) throws Exception{
	  JavascriptExecutor js = ((JavascriptExecutor)driver);
	  String bgcolor = element.getCssValue("backgroundColor");
	  for(int i=0;i<5;i++){
		  changeColor("rgb(0,200,0)" , element, driver);
		  Thread.sleep(1000);
		  changeColor(bgcolor , element, driver);
		  
	  }
	}
	
	
	//***********************CHANGE COLOR METHOD****************
	public static void changeColor(String color, WebElement element , WebDriver driver){
		 JavascriptExecutor js = ((JavascriptExecutor)driver);
		 js.executeScript("arguments[0].style.backgroundColor='"+color+"'", element);
		 
		 try{
			 Thread.sleep(20);
		 } catch(InterruptedException e)
		 {
			 
		 }
	}
	
	//**************DRAW BORDER/*********************
	public static void drawBorder(WebElement element,WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeAsyncScript("arguments[0].style.border='5px solid red'", element);
	}
	
	//**********************ALERT  METHOD****************
	public static void createAlert(WebDriver driver, String message){
		JavascriptExecutor js =((JavascriptExecutor)driver);
		js.executeScript("alert('"+message+"')");
	}
	
	//********************CLICK BY JS*******************
	public static void clickElementByJS(WebElement element, WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", element);
	}
	
	//******************REFRESH BROWSER BY JS******************
	public static void refreshBrowserByJS(WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("history.go[0]");
	}
	
	//*******************GET TITLE BY JS**************
	public static String getTitleByJS(WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}
	
	//*******************GET PAGE TEXT BY JS**************
		public static String getPageInnerTextByJS(WebDriver driver){
			JavascriptExecutor js = ((JavascriptExecutor)driver);
			String pageText = js.executeScript("return document.documentElement.innerText;").toString();
			return pageText;
		}
		
		//*************SCROLL DOWN **********************
		public static void scrollPageDown(WebDriver driver){
			JavascriptExecutor js = ((JavascriptExecutor)driver);
			js.executeScript("window.scrollTo(0 , document.body.scrollHight)");
		}
		
		//************SCROOL INTO VIEW****************************
		public static void scrollIntoView(WebElement element , WebDriver driver){
			JavascriptExecutor js = ((JavascriptExecutor)driver);
			js.executeScript("arguments[0].scroolIntoView(true); , element");
		}
	
	

}
