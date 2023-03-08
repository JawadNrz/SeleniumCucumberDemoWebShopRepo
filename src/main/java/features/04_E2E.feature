Feature:

  Scenario: Successful order of an item
    Given I navigate to "home" page
    And   I click on the "Log in" "page"
    And   I pass a "Thomasmueller@hotmail.de" to "Email" inputBox
    And   I pass a "123456" to "Password" inputBox
    And   I click the "Log in" button on the "Login" page
    When  I click on the "Jewelry" "page"
    And   I select "Name: A to Z" option from "Sort by" dropdown
    And   I select "List" option from "View as" dropdown
    And   I click on the "Create Your Own Jewelry" "product"
    And   I select "Silver (1 mm)" option from "Material" dropdown
    And   I pass a "30 cm" to "Length in cm" inputBox
    And   I select the "Heart" radio button
    And   I click the Add to cart button on the "Jewelry product" page
    And   I click on the "Shopping cart" "page"
    And   I click the "Agree" checkbox
    And   I click the "checkout" button on the "Shopping Cart" page
    And   I select "New Address" option from "Select a billing Address" dropdown
    And   I select "Germany" option from "Country" dropdown
    And   I pass a "Hamburg" to "City" inputBox
    And   I pass a "Kollwitzring" to "Address1" inputBox
    And   I pass a "123456" to "Postal code" inputBox
    And   I pass a "01761234567" to "Phone number" inputBox
    And   I click on the "Continue" button on the "Billing Address" page
    And   I click on the "Continue" button on the "Shipping Address" page
    And   I select the "Next Day Air (0.00)" radio button
    And   I click on the "Continue" button on the "Shipping Method" page
    And   I select the "Cash On Delivery (COD) (7.00)" radio button
    And   I click on the "Continue" button on the "Payment Method" page
    And   I click on the "Continue" button on the "Payment Information" page
    And   I click the Confirm button
    Then  I should see the Message "Your order has been successfully processed!"
    When  I click the "Continue" button on the "Order Completed" page
    And   the website is closed




