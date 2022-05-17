Feature: Contact Us Feature

Scenario Outline: Contact Us scenario with different set of data
Given User navigates to contact us page
When User fills the form from given sheetname "<SheetName>" and rownumber <RowNumber>
And User clicks on send button
Then it shows a successful message "Your message has been successfully sent to our team."

Examples: 
|SheetName|RowNumber|
|Inputs|0|
|Inputs|1|
