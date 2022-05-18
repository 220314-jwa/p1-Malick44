
	Scenario: successful login
		Given the user is on the homepage
		When the user enters the correct username
		And the user enters the correct password
		And the user clicks the login button
		Then the nav will show the user's first name
		
	Scenario: username does not exist
		Given the user is on the homepage
		When the user enters an incorrect username
		And the user clicks the login button
		Then an incorrect credentials message will be displayed
		
	Scenario: incorrect password
		Given the user is on the homepage
		When the user enters the correct username
		And the user enters the incorrect password
		And the user clicks the login button
		Then an incorrect credentials message will be displayed
		
	Scenario Outline: invalid input
		Given the user is on the homepage
		When the user enters the username "<username>"
		And the user enters the password "<password>"
		And the user clicks the login button
		Then an invalid input message will be displayed
name2 |     7 | Fail    |
