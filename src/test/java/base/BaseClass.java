package base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.Helper;

public class BaseClass {

	
	protected static WebDriver driver; 
	
	protected static String envName = "";
	protected static String configFileName = "";
	
	public static WebDriver setupBrowser() throws IOException {
		
		if(Helper.readProperty("browser").equalsIgnoreCase("chrome")) {
			
			String driverPath  = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
			
			System.setProperty("webdriver.chrome.driver", driverPath);
			//WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");

			driver = new ChromeDriver(options);
			
		} else if(Helper.readProperty("browser").equalsIgnoreCase("edge")) {
			
			String driverPath  = System.getProperty("user.dir") + "\\drivers\\msedgedriver.exe";
			
			System.setProperty("webdriver.edge.driver", driverPath);
			
			driver = new EdgeDriver();
			
		} else {
			
			String driverPath  = System.getProperty("user.dir") + "\\drivers\\geckodriver.exe";
			
			System.setProperty("webdriver.gecko.driver", driverPath);
			
			driver = new FirefoxDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		configFileName = "./%s-config.properties";
		envName = System.getProperty("env");
		System.out.println("Environment: " + envName);
		configFileName = String.format(configFileName, envName);

		if(envName.equalsIgnoreCase("qa")) {
			driver.get(Helper.readPropertyMultiEnv("url", configFileName));

		} else if(envName.equalsIgnoreCase("int2")) {

			driver.get(Helper.readPropertyMultiEnv("url", configFileName));
		}

		
		return driver;
	}
	
	
	public static void closeBrowser() {
		
		driver.quit();
	}
}
