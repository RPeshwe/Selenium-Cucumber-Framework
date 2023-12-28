Feature: Add to cart and place order flow

  @AddToCartFlow @Regression
  Scenario: Search And increase count test
    Given User is on GreenCart landing page
    When User searched with short name Tom and extracted actual name of product
    And User increases quantity as four and added to cart
    Then click on cart and validate item name and quantity
    And click on proceed to checkout validate item name and quantity
