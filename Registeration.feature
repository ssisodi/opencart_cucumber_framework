Feature: Register a new user 
@module2
		Scenario: Successful registration with valid details
				Given User launch registration page
				And opens the URL "https://awesomeqa.com/ui/"
				When user navigates to MyAccount menu
				And click on register
				And I enter my First Name as "Siddhanth" 
				And I enter my Last Name as "Sisodia" 
				And I enter my email as "sidfakeaccount@gmail.com" 
				And I enter my telephone as "90909090909"
				And I set my password as "test@123"
				And I confirm my password as "test@123"
				And I have read, agreed and clicked the privacy policy checkbox 
				And I click on the Continue button 
				Then I should be registered successfully 
				