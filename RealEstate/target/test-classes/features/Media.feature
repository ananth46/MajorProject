Feature: Media

  Background: Verify login with valid credentials
    Given Initialize the browser with chrome
    And Navigate to  "http://realty-real-estatem1.upskills.in/my-profile/" site
    And Click on Login link in home page to land on Secure sign in Page
    When I entered valid mohankrishna176@gmail.com and valid Secret@123&& logs in
    Then Click on signin button

  Scenario: Verify the functionality of Media Section
  	Given click on mediasectionA
    And User is on media sectionA
    When click on Library optionA
    And click on Add New buttonA
    And click on select filesA
    Then check file uploading functinalityA
    And close the browserA
    

  Scenario: Verify the functionality of dropdowns 
    Given click on dropdownA
    When User choose any option from dropdownA
    Then Appropriate result should be displayedA
    And close the browserA

	Scenario: Verify Second dropdown functionality
		Given User is in first dropdownA
		Then Choose any option from dropdownA
		And close the browserA
	
	Scenario: Verify Search box functionality
		Given click on search boxA
		When user enters any text inside the search box A
		Then result should be displayedA
		And close the browserA
	
	
	
	
	
	
	