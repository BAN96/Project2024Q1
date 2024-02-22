Feature: landing page feature

Scenario: verify the page header

Given user opens the url
When user get the page header
Then Page Header should be "PRODUCT STORE"

Scenario: verify the screen opening the loginpopup

Given user opens the url
When click on Login option
Then user gets the page title and page Title should be "Log in"