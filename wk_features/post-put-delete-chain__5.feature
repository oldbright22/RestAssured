Feature: create, update and delete actions in service now

	@post-put-delete-chain__5
  Scenario: create change request in service now

    When create postBody
    And send postRequest
    Then validate postResponse

  Scenario: update change request in service now

    When create putBody
    And send putRequest
    Then validate putResponse

  Scenario: delete change request in service now

    When send deleteRequest
    Then validate deleteResponse
