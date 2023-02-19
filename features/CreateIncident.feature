Feature: ServiceNow Incident Management

Scenario Outline: Get all the incidents

Given set the endpoint
And add the auth
And add the queryparams as "sysparm_fields" and "sys_id, number, category"
When post the request with short description as "<short_desc>" and category as "<category>"
Then validate the response as 201

Examples:
 |short_desc|category|
 # 1st data row
 |Create Incident with body as string 1|software|
 # 2nd data row
 |Create Incident with body as string 2|hardware|
 