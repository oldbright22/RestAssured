Feature: ServiceNow Incident Management


Scenario: Get all the incidents

Given set the endpoint
And add the auth
And add the queryparams
|sysparm_fields	|sys_id, number, category, short_description, description	|
|category|software|
When send the request with QP
Then validate the response





