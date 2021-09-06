#Author: Priyanka Poojari

@PositiveFlows
Feature: Test CRUD methods in StudentsApp REST API functionality  POSITIVE FLOW
Description: The purpose of this test is to validate happy flow of the API's

Scenario: Add Student record
Given I Set student service api endpoint
When I Set request HEADER
And Send a POST HTTP request "{\"id\":@id,\"firstName\": \"Jane\",\"lastName\": \"Doe\",\"className\":\"3 A\",\"nationality\": \"American\"}"
Then I receive valid Response

Scenario: Update Student record
Given I Set student service api endpoint
When I Set request HEADER
And Send a PUT HTTP request 
Then I receive valid Response

Scenario: Get Student record by ID
When I Set request HEADER
And Send a GET HTTP request by ID
Then I receive valid Response

Scenario: Get Student record by CLASS
When I Set request HEADER
And Send a GET HTTP request by Class "8A"
Then I receive valid Response

Scenario: Get All Student record
Given I Set student service api endpoint
When I Set request HEADER
And Send a GET HTTP request 
Then I receive valid Response

Scenario: Delete Student record
Given I Set student service api endpoint
When I Set request HEADER
And Send a DELETE HTTP request 
Then I receive valid Response