Feature: This is excel feature writing to output.xlsx
  Scenario: List Scenario
    Given I write to excel following data to sheet "List" as "list"
      |  data11 |
      |  data12 |
      |  data13 |
      |  data14 |

  Scenario: Map Scenario
    Given I write to excel following data to sheet "Map" as "map"
      | field1 |  data11 |
      | field2 |  data12 |
      | field3 |  data13 |
      | field4 |  data13 |

  Scenario: Lists Scenario
    Given I write to excel following data to sheet "Lists" as "lists"
      | data11 |  data12 | data13 |   data11 |
      | data21 |  data22 | data23 |  data11 |
      | data21 |  data22 | data23 |  data11 |

  Scenario: Maps Scenario
    Given I write to excel following data to sheet "Maps" as "maps"
      | field1 |  field2 | field3 | field4 |
      | data11 |  data12 | data13 | data14 |
      | data21 |  data22 | data23 | data24 |
