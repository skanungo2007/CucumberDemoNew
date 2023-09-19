Feature: Telecom Project Smoke Test


	Background:
	Given I access the url and open the browser
	When I verify that the title of the page matches

	@Smoke
	Scenario: Verify that user is able to add customer details and pay bill
		Then I click on Add Customer Link
		And I should see the customer portal page
		And I should be able to fill up customer details
		And I should see the customer details
		And I close the browser
		