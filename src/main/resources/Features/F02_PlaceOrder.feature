@Scenario
Feature: Place Order:

  @SmokeTest
  Scenario: verify that user can Place New Order:
    Given User Login with Valid Credientials
    When  User Click on What's News
    And   User Choose Product
    And   User Click at Add to Compare List
    Then  Product shall added to compare list Successfully
    And   User Click on Add Product to Card
    And   User Click Go to Card and Proceed to Checkout
    And   User Fill All Shipping Address and Payment information
    Then  Verify Order Created Successfully

