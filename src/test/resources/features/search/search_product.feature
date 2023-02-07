@feature:search @feature:product
Feature: Search product

  Background:
    Given I get a 200 from the product endpoint

  @positive
  Scenario Outline: Search test with available product
    When I call the search product endpoint <product>
    Then I verify that <product> should be in the search results
    And the schema should match with the specification defined in "search_product.json"
    Examples:
      | product |
      | apple   |

  @negative
  Scenario: Search test with unavailable product tea
    When I call the search product endpoint tea
    Then I verify that a not found error should be displayed in search results

  @negative
  Scenario: Search test without product
    When I call the search product endpoint ""
    Then I verify that an unauthorized error should be displayed in search result
