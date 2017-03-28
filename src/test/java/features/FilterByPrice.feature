Feature: Vehicle filter by price on Carmudi page

	Background:
		User navigates to Carmudi Categories Page
		Given I am on the Carmudi Search Page

	Scenario: Customer input 500,000 as the minimum amount on the Price Section
		When i input 500000 on the "From:" textbox
		Then i should see the list of available vehicle with the amount entered
			And the vehicle rates are sort from the "lowest to highest"

#	Scenario: Customer input 50,000 to 100,000 amount on the Price Section
#		When i input 100000 on the "From:" textbox
#			When i input 500000 on the "To:" textbox
#		Then i should see the list of available vehicle with the amount entered
#			And the vehicle rates are sort from the "lowest to highest"
#			And the vehicle rates are sort from the "highest to lowest"
#
#	Scenario: Customer select new condition of vehicle with the 
#		When i click the New checkbox on the Condition tab 
#			And i input 10000 on the "From:" textbox
#		Then i should see the list of available vehicle with the amount entered
#		 Then i should see to search home page of the Carmudi website
#		
#	Scenario: Customer input 100,000 as the maximim amount on the Price Section
#		When i input 100000 on the "To:" textbox
#		Then i should see the list of available vehicle with the amount entered
#			And the vehicle rates are sort from the "highest to lowest"
#
#	Scenario: Customer tries to input a special characters and alphabet
#		When i input "special characters" on the "From:" textbox
#			And i input "alphabet" on the "To:" textbox
#		Then the system will validated the input text
#	
