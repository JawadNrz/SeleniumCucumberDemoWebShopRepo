Feature: An Article Rating

  Scenario: Write a review for an article
    Given I navigate to "home" page
    And   I click on the "Log in" "page"
    And   I pass a "Thomasmueller@hotmail.de" to "Email" inputBox
    And   I pass a "123456" to "Password" inputBox
    And   I click the "Log in" button on the "Login" page
    When  I click on the "Jewelry" "page"
    And   I click on the "Create Your Own Jewelry" "product"
    And   I click on the "Add your review" "page"
    And   I pass a "Good Quality" to "Review title" inputBox
    And   I pass a "Very comfortable to wear and looks very nice" to "Review text" inputBox
    And   I click 4 stars as rating
    And   I click the "Submit review" button on the "Write your own review" page
    Then  I should see "information" "Product review is successfully added."
    And   the website is closed

      # Negative Test Case:
      # one of the mandatory fields (Review Text) is left blank
      # we get the error message "Review Text is required"

  Scenario: Rating an article without filling in one of the mandatory "review text" fields
    Given I navigate to "home" page
    And   I click on the "Log in" "page"
    And   I pass a "Thomasmueller@hotmail.de" to "Email" inputBox
    And   I pass a "123456" to "Password" inputBox
    And   I click the "Log in" button on the "Login" page
    When  I click on the "Jewelry" "page"
    And   I click on the "Create Your Own Jewelry" "product"
    And   I click on the "Add your review" "page"
    And   I pass a "Good Quality" to "Review title" inputBox
    And   I click 4 stars as rating
    And   I click the "Submit review" button on the "Write your own review" page
    Then  I should see "error message" "Review text is required."
    And   the website is closed