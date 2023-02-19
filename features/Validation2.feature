Feature: ServiceNow Incident Management

Scenario: Get all the incidents with multi query params

Given set the endpoint
And add the auth
And add the queryparams as "sysparm_fields" and "sys_id, number, category"
When send the request
Then validate the response

Scenario: Get all the incidents

Given set the endpoint
And add the auth
And add the queryparams
|sysparm_fields	|sys_id, number, category, short_description, description	|
|category|software|
When send the post request
Then validate the response for below
|result.sys_created_by|admin|
|result.sys_class_name|incident|
|result.urgency|3|




