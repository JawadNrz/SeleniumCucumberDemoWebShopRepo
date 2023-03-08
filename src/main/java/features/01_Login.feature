Feature: Login

  Scenario: Successful login with valid user credentials
    Given I navigate to "home" page
    And   I click on the "Log in" "page"
    When  I pass a "Thomasmueller@hotmail.de" to "Email" inputBox
    And   I pass a "123456" to "Password" inputBox
    And   I click the "Log in" button on the "Login" page
    Then  I should see "element" "Log out"
    And   the website is closed


    # Negative Test Cases:
    # scenario 1: only the email input field filled in without entering a password

  Scenario: Login fails with incorrect email address
    Given I navigate to "home" page
    And   I click on the "Log in" "page"
    When  I pass a "Tester@test.de" to "Email" inputBox
    And   I click the "Log in" button on the "Login" page
    Then  I should see "error message" "Login was unsuccessful. Please correct the errors and try again."
    And   the website is closed

    # scenario 2: correct email address but wrong password
    # we get the error message "The credentials provided are incorrect"

  Scenario: Login fails with incorrect password
    Given I navigate to "home" page
    And   I click on the "Log in" "page"
    When  I pass a "Thomasmueller@hotmail.de" to "Email" inputBox
    And   I pass a "1234" to "Password" inputBox
    And   I click the "Log in" button on the "Login" page
    Then  I should see "error" "The credentials provided are incorrect"
    And   the website is closed



