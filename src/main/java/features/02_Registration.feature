Feature: Registration


  Scenario: Successful registration with valid user credentials
    Given I navigate to "home" page
    And   I click on the "Register" "page"
    When  I fill in all the required fields with valid user details
    And   I click the "Register" button on the "Register" page
    Then  I should see "the button" "Continue"
    And   I click the "Continue" button on the "Register" page
    And   I should see "the message" "Welcome to our store"
    And   the website is closed

      # Negative Test Cases:
      # scenario 1: one of the mandatory fields email is left blank

  Scenario: Registration fails with missing required fields
    Given I navigate to "home" page
    And   I click on the "Register" "page"
    When  I select the "Male" radio button
    And   I pass a "Markus" to "FirstName" inputBox
    And   I pass a "Mueller" to "LastName" inputBox
    And   I pass a "123456" to "Password" inputBox
    And   I pass a "123456" to "ConfirmPassword" inputBox
    And   I click the "Register" button on the "Register" page
    Then  I should see "error message" "Email is required"
    And   the website is closed

    # scenario 2: the email address already exists
    # We get the error message "The specified email already exists"

  Scenario: Registration fails with existing email address
   Given  I navigate to "home" page
    And   I click on the "Register" "page"
    When  I select the "Male" radio button
    And   I pass a "Thomas" to "FirstName" inputBox
    And   I pass a "Mueller" to "LastName" inputBox
    And   I pass a "Thomasmueller@hotmail.de" to "Email" inputBox
    And   I pass a "123456" to "Password" inputBox
    And   I pass a "123456" to "ConfirmPassword" inputBox
    And   I click the "Register" button on the "Register" page
    Then  I should see "error" "The specified email already exists"
    And   the website is closed

    # scenario 3: we pass an invalid email address
    # We get the error message "Wrong email"

  Scenario: Registration fails with invalid email address
    Given I navigate to "home" page
    And   I click on the "Register" "page"
    When  I select the "Male" radio button
    And   I pass a "Thomas" to "FirstName" inputBox
    And   I pass a "Mueller" to "LastName" inputBox
    And   I pass a "Thomasmuellerhotmail.de" to "Email" inputBox
    And   I pass a "123456" to "Password" inputBox
    And   I pass a "123456" to "ConfirmPassword" inputBox
    And   I click the "Register" button on the "Register" page
    Then  I should see "error message" "Wrong email"
    And   the website is closed


    


