Feature: Wishlist


  Scenario: add an item to the wishlist
    Given I navigate to "home" page
    And   I click on the "Jewelry" "page"
    When  I select "Name: A to Z" option from "Sort by" dropdown
    And   I select "List" option from "View as" dropdown
    And   I click on the "Create Your Own Jewelry" "product"
    And   I select "Silver (1 mm)" option from "Material" dropdown
    And   I pass a "30 cm" to "Length in cm" inputBox
    And   I select the "Heart" radio button
    And   I click the "Add to wishlist" button on the "Create Your Own Jewelry product" page
    And   I click on the "Wishlist" "page"
    Then  I should see "element" "Create Your Own Jewelry"
    And   the website is closed


  Scenario: add an item to the wishlist and then remove this item from the wishlist
    Given I navigate to "home" page
    And   I click on the "Jewelry" "page"
    When  I select "Name: A to Z" option from "Sort by" dropdown
    And   I select "List" option from "View as" dropdown
    And   I click on the "Create Your Own Jewelry" "product"
    And   I select "Silver (1 mm)" option from "Material" dropdown
    And   I pass a "30 cm" to "Length in cm" inputBox
    And   I select the "Heart" radio button
    And   I click the "Add to wishlist" button on the "Create Your Own Jewelry product" page
    And   I click on the "Wishlist" "page"
    Then  I should see "element" "Create Your Own Jewelry"
    When  I click the "Remove" checkbox
    And   I click the "Update wishlist" button on the "Wishlist" page
    Then  I should see " the Information" "The wishlist is empty!"
    And   the website is closed

