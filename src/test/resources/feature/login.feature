Feature: User is on Login Page 

Scenario: User validates the title of the login Page
Given User is on the Login Page
Then User checks the title of the page

Scenario: User is able to login through the Login Page
Given User is on the Login Page
When User enters the <username> and <password>
|username|password|
|parasheradi94@gmail.com|Adish@2019|
Then User checks the title of the page
