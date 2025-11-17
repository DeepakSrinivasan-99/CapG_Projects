Feature: SauceDemo Login and Logout

  Scenario: Login with valid credentials and logout
    Given user launches the browser and opens SauceDemo login page
    When user enters username "standard_user" and password "secret_sauce"
    And user clicks on the login button
    Then user should be navigated to the home page
    And user logs out from the application