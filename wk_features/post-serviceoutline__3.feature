Feature: Verify query params and passing parameters in requests

  @post-serviceoutline__3
  Scenario: Verify Get incidents of chnage request table

    When Filter with query params "sysparm_fields" and "number,sys_id,short_description"
    And send get request
    Then validate get response

  @post-put-delete-chain__5
  Scenario Outline: Create post withItems passed as parameters

    When create postRequest withItems <short_desc> and <category>
    Then validate postRequest withItems <short_desc> and <category>

    Examples: 
      | short_desc     | category |
      | This is First  | Software |
      | This is Second | Hardware |
      | This is Third  | Other    |
