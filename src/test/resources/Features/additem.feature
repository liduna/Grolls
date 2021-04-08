Feature: Adding item into cart
  Background:
    Given I navigated  a webpage grolls

  @addingItems
  Scenario: I am able to add to same items into cart

    When I select the size of a product in drop-down menu
    And I select the amount of the products
    And I press add to cart button
    Then I am able to  see two items in the cart

  @controllingItemsInCart

  Scenario: I control added items against the cart
    When I select two same items of same size
    And I add them into cart
    And I click on cart icon
    Then I am able to see previously selected items added into cart
    And I have two of these items in the cart

  @addingViaNumLock

  Scenario: I am able to add the selected size by changing the number in input field
    When I select the size of an item
    Then I can increase its number in the quantity input field
    And I can add selected number of items into cart

