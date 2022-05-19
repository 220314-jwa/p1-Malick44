Feature: User Login from HomePage

Scenario: successful login
Given the user is on the homepage
When the user clicks the login button
And the user enters the correct password
And the user clicks the SignOn button
Then the nav will show the user's first name

Scenario: username does not exist
Given the user is on the homepage
  When the user clicks the login button
And the user enters an incorrect username
And the user clicks the login button
Then an incorrect credentials message will be displayed

Scenario: incorrect password
Given the user is on the homepageWhen the user clicks the login button
And the user enters the correct username
And the user enters the incorrect password
And the user clicks the login button
Then an incorrect credentials message will be displayed

Scenario Outline: invalid input
Given the user is on the homepage
  When the user clicks the login button
And the user enters the username "<username>"
And the user enters the password "<password>"
And the user clicks the login button
Then an invalid input message will be displayed
  Examples:
    | username | password |
    |remis     |  pass    |
    |remis1    |  pass2   |
    |remis5    |  0pass   |