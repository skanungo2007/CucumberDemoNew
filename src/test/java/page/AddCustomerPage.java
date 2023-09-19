package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import utility.Helper;

public class AddCustomerPage extends BaseClass {
	
	
	@FindBy(id="done")
	WebElement bcg;

	@FindBy(id="fname")
	WebElement firstName;
	
	@FindBy(id="lname")
	WebElement lastName;
	
	@FindBy(id="email")
	WebElement emailId;
	
	@FindBy(xpath="//textarea")
	WebElement address;
	
	@FindBy(id="telephoneno")
	WebElement phone;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement subBtn;
	
	
	@FindBy(xpath="//table[@class='alt access']")
	WebElement customerDetails;
	
	
	public AddCustomerPage(WebDriver driver) {
		
		BaseClass.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public String verifyAddCustomerPage() {
		
		return driver.getTitle();
		
	}
	
	public void fillCustomerDetails() {
		
		
		
		Helper.clickElement(bcg);
		
		firstName.sendKeys("Carolina");
		lastName.sendKeys("Williams");
		
		Helper.clickElement(emailId);
		emailId.sendKeys("carolina1889@gmail.com");
		
		
		Helper.clickElement(address);
		address.sendKeys("North Xing Road");
		
		Helper.clickElement(phone);
		phone.sendKeys("9477007860");
		
		subBtn.click();
		
	}
	
	public void getCustomerDetails() {
		
		Helper.explicitWaitVisible(customerDetails);
		
		System.out.println(customerDetails.getText());
	}
}
