#Author: anokarb1996@gmail.com
Feature: Admin Login Page functionality

  Scenario: verify the login page title
    Given user opens the admin url
    Then user gets the page title and page Title should be "Administration"

  Scenario: login to open cart Demo as a admin
    Given user opens the admin url
    When user enters the username "demo" password "demo"
    And user clicks on login button
    Then user gets the page title and page Title should be "Dashboard"

  Scenario: verify the forget password link
    Given user opens the admin url
    When user clicks on Forgetten password
    Then user gets the page title and page Title should be "Forgot Your Password?"
