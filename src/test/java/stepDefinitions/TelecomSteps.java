package stepDefinitions;

import java.io.IOException;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.AddCustomerPage;
import page.HomePage;

public class TelecomSteps extends BaseClass {

	
	private HomePage getHomePage() {
		
		HomePage home = new HomePage(driver);
		return home;
	}
	
	private AddCustomerPage getCustomer() {
		
		AddCustomerPage customer = new AddCustomerPage(driver);
		return customer;
	}
	
	
	
	//Background
	
	@Given("I access the url and open the browser")
	public void i_access_the_url_and_open_the_browser() throws IOException {
	   
		setupBrowser();
	}
	@When("I verify that the title of the page matches")
	public void i_verify_that_the_title_of_the_page_matches() {
	  
		System.out.println(getHomePage().getTitle());
	}

	
	//End of background steps
	
	
	
	@Then("I click on Add Customer Link")
	public void i_click_on_add_customer_link() {
	    
		getHomePage().clickAddCustomer();
	}
	
	
	@And("I should see the customer portal page")
	public void i_should_see_the_customer_portal_page() {
	  
		System.out.println(getCustomer().verifyAddCustomerPage());
		
	}
	
	
	@And("I should be able to fill up customer details")
	public void i_should_be_able_to_fill_up_customer_details() {
	   
		getCustomer().fillCustomerDetails();
		
	}
	@And("I should see the customer details")
	public void i_should_see_the_customer_details() {
	    
		getCustomer().getCustomerDetails();
	}
	
	@And("I close the browser")
	public void i_close_the_browser() {

		closeBrowser();
	}

}
