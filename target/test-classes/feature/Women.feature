Feature: User adds woman dresses into the cart

Background: 
Given user has already logged in to application
|username|password|
|parasheradi94@gmail.com|Adish@2019|
Then User navigates to homepage having message as "Welcome to your account. Here you can manage all of your personal information and orders."
Then User must validate the title as "My account - My Store"

Scenario: User navigates to the Women page
Given User hower to the Women option
When User clicks on the Summer Dresses
And User sees the title of the page as "Summer Dresses - My Store"

Scenario: User clicks on proceed to checkout button
Given User hower to the Women option
When User clicks on the Summer Dresses
And User clicks on Add to cart button
When User clicks on proceed to checkout button

