Feature: Login Page Functionality

Background:
Given user opens the url
And click on Login option

Scenario: verify the login pagetitle
Then user gets the page title and page Title should be "Log in"

Scenario: login to the application with invalid credentials

When user enters username "TESTDEMO"
And user enters Password "test1234"
And user clicks on Login button
Then Alert will show with message "Wrong password."

Scenario: login to the application with valid credentials

When user enters username "TESTDEMO"
And user enters Password "test123"
And user clicks on Login button
Then user goto Homepage and WelcomeMsg should be "Welcome TESTDEMO"

