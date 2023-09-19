package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class Helper extends BaseClass {
	
	public static String readPropertyMultiEnv(String key, String name) throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\"+name);
		
		Properties property = new Properties();
		
		property.load(fis);
		
		return property.get(key).toString();
	}

	public static String readProperty(String key) throws IOException {

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\config.properties");

		Properties property = new Properties();

		property.load(fis);

		return property.get(key).toString();
	}

	
	public static void explicitWaitVisible(WebElement element) {
		
		WebDriverWait expWait = new WebDriverWait(driver, 10);
		expWait.pollingEvery(Duration.ofSeconds(2));
		expWait.until(ExpectedConditions.visibilityOf(element));
		
		
	}
	
	public static void clickElement(WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		
	}
	
	public static void sendValue(WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='Red Cross Road';", element);
		
	}
	
	
	
}
