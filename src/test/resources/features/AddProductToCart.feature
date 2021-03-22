Feature: Add Products To Cart

  Background:
    Given Launch Flipkart application
    And User is logged in

  Scenario: Add product with lowest price to cart

    Given User enters product name in Search field
    When User clicks on Price-low-to-high link
    And User clicks on first product with lowest price
    Then User adds the product to cart
