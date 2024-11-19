Feature: Detail Page

  @Positive
  Scenario: Open Detail Page
    Given User Success Login
    When User click product name
    Then User can see detail product

  @Positive
  Scenario: Add product to cart and Checkout product
    Given User Success Login
    When User click add to cart button
    And User click icon cart
    And User click checkout button
    When User fill firstname
    And User fill lastname
    And user fill zipcode
    And User click button continue
    Then User can see checkout overview page

  @Negative
  Scenario: Remove product to cart
    Given User Success Login
    When User click add to cart button
    And User click icon cart
    And User click remove button
    Then User can't see product