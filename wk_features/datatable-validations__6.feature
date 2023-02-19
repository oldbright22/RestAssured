Feature: create post and verify via data table

  Scenario: Create post request with data table validations

    When create post body
    And  send post request
    Then validate post response
      | urgency   |             3 |
      | approval  | not requested |
      | knowledge | false         |
      | number    | CHG           |
