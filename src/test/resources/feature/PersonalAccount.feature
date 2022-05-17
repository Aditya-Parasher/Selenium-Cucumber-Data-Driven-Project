Feature: User is on Personal Account Information 

Background:
Given user has already logged in to application
|username|password|
|parasheradi94@gmail.com|Adish@2019|
Then user is on the HomePage and validates the title of the page as "My account - My Store"

Scenario Outline: Fill personal information with different set of data
Given User navigates to Personal Account Information page
When User fills the form from given sheetname "<SheetName>" and rownumber <RowNumber>

Examples: 
|SheetName|RowNumber|
|PersonalAccountInformation|0|
|PersonalAccountInformation|2|
|PersonalAccountInformation|3|
|PersonalAccountInformation|5|
