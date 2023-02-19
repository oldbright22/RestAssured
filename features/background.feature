Feature: ServiceNow Incident Management

Background:
Given set the endpoint
And add the auth

Scenario: Get all the incidents with multi query params
Given add the queryparams as "sysparm_fields" and "sys_id, number, category"
When send the request
Then validate the response

Scenario: Get all the incidents
Given add the queryparams
|sysparm_fields	|sys_id, number, category	|
|category|software|
When send the request
Then validate the response



