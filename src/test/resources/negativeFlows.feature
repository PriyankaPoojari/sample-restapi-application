#Author: Priyanka Poojari

@NegativeFlows
Feature: Test CRUD methods in StudentsApp REST API functionality by providing INVALID DATA
Description: The purpose of this test is to invalidate happy flow of the API's

Scenario: Add Student record- Negative
Given I Set student service api endpoint
When I Set request HEADER
And Send a POST HTTP request "{\"id\":@id,\"firstName\": \"Mike\",\"lastName\": \"Wong\",\"className\":\"3 A\",\"nationality\": \"\"}"
Then I receive ininvalid Response

Scenario: Update Student record
Given I Set student service api endpoint
When I Set request HEADER
And Send a PUT HTTP request 
Then I receive invalid Response

Scenario: Get Student record by ID
When I Set request HEADER
And Send a GET HTTP request by ID
Then I receive invalid Response

Scenario: Get Student record by CLASS
When I Set request HEADER
And Send a GET HTTP request by Class "10ABC"
Then I receive invalid Response

Scenario: Delete Student record
Given I Set student service api endpoint
When I Set request HEADER
And Send a DELETE HTTP request 
Then I receive invalid Response