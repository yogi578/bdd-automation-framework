#Author: yogesh padekar
Feature: Sample test data scenario

@Corporate
  Scenario: Verify corporate sign up
    Given User hits url "https://business.cleartrip.com/corporate-customers/signup"
    And User reads test data from file "corporatesignup.json"
    Then User enters "companyname"
    And User enters "firstname"
    And User enters "lastname"
    And User enters "address"
    And User enters "city"
    And User enters "pancardno"
    And User enters "email"
    And User enters "mobileno"
