Feature: Full fee feature test

  Scenario: Successful fee creating in basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "fee" screen
    And search and delete "Brazilia fee1" entities by "name"
    When I create fee following fields
      | name     | Brazilia fee1 |
      | code     | fee1          |
      | intCode  | code1         |
      | priority | 17            |
    Then "Fee Type" is successfully "created"


  Scenario: Successful fee creating in basqar using arbitrary fields without intCode
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "fee" screen
    And search and delete "Brazilia fee1" entities by "name"
    When I create fee following arbitrary fields
      | name     | Brazilia fee1 |
      | code     | fee1          |
      | priority | 17            |
    Then "Fee Type" is successfully "created"

  Scenario: Successful fee creating in basqar using arbitrary fields with intCode
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "fee" screen
    And search and delete "Brazilia fee1" entities by "name"
    When I create fee following arbitrary fields
      | name     | Brazilia fee1 |
      | code     | fee1          |
      | intCode  | code1         |
      | priority | 17            |
    Then "Fee Type" is successfully "created"

  Scenario: Successful fee creating in basqar with data
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in
    Given I navigate to "fee" screen
    And search and delete "Brazilia fee1" entities by "name"
    When I try to fill in fee with following data
      | name          | code | intCode | priority | errorIn   |
      |               | fee1 | code1   | 17       | name     |
      | Brazilia fee2 |      | code2   | 18       | code     |
      | Brazilia fee3 | fee3 |         | 19       |          |
      | Brazilia fee4 | fee4 | code4   |          | priority |


    # Differences to scenario outline:
    # 1) datatable will be run only for one step, not the whole scenario
    # 2) it will not run you step several times, it will just provide you with datatable
    # you must use your own loop to iterate over datatable and verify data
