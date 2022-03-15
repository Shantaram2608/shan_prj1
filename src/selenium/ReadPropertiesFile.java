package selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadPropertiesFile {
	static WebDriver driver;

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("E:/Workspace/selenium/src/selenium/config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.get(prop.getProperty("URL"));
		String id= prop.getProperty("id");
		String passid = prop.getProperty("passid");
		driver.findElement(By.id(id)).sendKeys(prop.getProperty("userName"));
		driver.findElement(By.id(passid)).sendKeys(prop.getProperty("pass"));
		driver.findElement(By.xpath(prop.getProperty("button_xpath"))).click();
        System.out.println("login successfully by using properties file.....");
        driver.close();
	}
}
