Feature: landing page feature

@Skip
Scenario: verify the page header

Given user opens the url
When user get the page header
Then Page Header should be "PRODUCT STORE"

@Skip
Scenario: verify the screen opening the loginpopup

Given user opens the url
When click on Login option
Then user gets the page title and page Title should be "Log in"

@Functional @Regression
Scenario Outline: Search for a product

Given user opens the url
And click on Login option
And user logged in with credentials User "<username>" and Password "<password>"
And user goto Homepage and WelcomeMsg should be "Welcome TESTDEMO"
When user clicks on category "Laptops"
Then search for a product "2017 Dell 15.6 Inch" with price "$700"

Examples:
|username|password|
|TESTDEMO|test123|