Feature: Adding item into cart

  @addingItems
  Scenario: I am able to add to same items into cart
    Given I navigated to a webpage https://www.grolls.se/helags-t-shirt--svart1100099.html
    When I select the amount of products in drop-down menu
    And I select the amount of the products
    And I press add to cart button
    Then I am able to  add the item to cart
