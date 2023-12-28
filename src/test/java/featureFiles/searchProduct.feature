Feature: Search and place order for products

  @Regression
  Scenario Outline: Search experience for product search in both home and offers page
    Given User is on GreenCart landing page
    When User searched with short name <ProductShortName> and extracted actual name of product
    And User searched for same shot name <ProductShortName> in offers page to check if product exist
    Then Validate both names are same
    Examples:
      | ProductShortName |
      | Tom              |
      | Beet             |

