package page;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class HomePage extends BaseClass {
	
	@FindBy(linkText="Add Customer")
	WebElement addCustomer;

	@FindBy(linkText="Add Tariff Plan")
	WebElement addTariffPlan;
	
	@FindBy(linkText="Add Tariff Plan to Customer")
	WebElement addTariffCustomer;
	
	@FindBy(linkText="Pay Billing")
	WebElement payBill;
	
	
	private static final Logger logger = LogManager.getLogger(HomePage.class);
	
	public HomePage(WebDriver driver) {
		
		BaseClass.driver = driver;
		
		PageFactory.initElements(driver, this);
		
		
	}
	
	
	public String getTitle() {
		
		return driver.getTitle();
		
	}
	
	
	public void clickAddCustomer() {
		
		addCustomer.click();
		
		logger.info("Clicked on Add Customer");
	}
	
	public void clickAddTariffPlan() {
		
		addTariffPlan.click();
		
	}
	
	public void clickAddTariffCustomer() {
		
		addTariffCustomer.click();
		
	}
	
	public void clickPayBilling() {
		
		payBill.click();
	}
	
}
