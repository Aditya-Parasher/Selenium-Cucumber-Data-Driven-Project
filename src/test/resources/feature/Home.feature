Feature: User is on Login Page 

Background: 
Given user has already logged in to application
|username|password|
|parasheradi94@gmail.com|Adish@2019|

Scenario: User validates the title of the Home Page
Given User is on the Home Page
Then User validates the header of the page

Scenario: User is able to get the count of account list items
Given User is on the Home Page
When Then user gets accounts section
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
And accounts section count should be 5
When User clicks on personal information list item
