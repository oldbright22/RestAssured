Feature: ServiceNow Incident Management

Scenario: Get all the incidents

Given set the endpoint
And add the auth
And add the queryparams as "sysparm_fields" and "sys_id, number"
When send the request with QP
Then validate the response