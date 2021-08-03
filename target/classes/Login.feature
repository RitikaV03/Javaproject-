Feature: Github Login functionality

  Scenario: User is trying to singin in GitHub account using Invalid credential
    Given User is on GitHub login Page
    When user enter Invalid credential and click submit button 
    Then 'Incorrect username or password.' Message should display
   
  Scenario: User is trying to singin in GitHub account using valid credential
    Given User is on GitHub login Page
    When user enter valid credential and click submit button
    Then user should successfully Sigin on his Github Account