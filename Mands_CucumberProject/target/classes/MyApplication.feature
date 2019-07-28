Feature: Test Mands smoke scenario

		Background: Open the application
 		Given Open CARD login page
 		When 	Submit username and password
 		Then 	Gets logged in 

		Scenario: Test Open the BCBS Report 
		Given Select child name
		When  Curriculum Language 
		And   Lesson Manding Fluency
		Then  Mands buttons should visible.
		
		
	