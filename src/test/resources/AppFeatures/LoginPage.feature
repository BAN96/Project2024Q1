Feature: Login Page Functionality

Background:
Given user opens the url
And click on 'My Account' Dropmenu
And click on 'Login' option

Scenario: login to the application with valid credentials

When user enters Email "anokarao@gmail.com"
And user enters Password "12345"
And user clicks on login button
Then user gets the page title and page Title should be "Account Login"

Scenario: login to the application with invalid credentials

When user enters Email "anokarao@gmail.com"
And user enters Password "123456"
And user clicks on login button
Then user gets the validation message "Warning: No match for E-Mail Address and/or Password."