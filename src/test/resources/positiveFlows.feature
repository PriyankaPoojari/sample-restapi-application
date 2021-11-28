#Author: Priyanka Poojari

@PositiveFlows
Feature: Test CRUD methods in StudentsApp REST API functionality  POSITIVE FLOW
Description: The purpose of this test is to validate happy flow of the API's
	
	Background:
	Given I set Base url
	And I Set request HEADER

Scenario Outline: Add Student record
#Given I Set student service api endpoint "/student"
#When I Set request HEADER
When Send a POST HTTP request to "<Endpoint>" and "<RequestBody>"
Then I receive valid Response
Examples:
	|	Endpoint | RequestBody |
	|	/student | {\"id\":@id,\"firstName\": \"Jane\",\"lastName\": \"Doe\",\"className\":\"3A\",\"nationality\": \"America\"} |
	|	/student | {\"id\":@id,\"firstName\": \"Danny\",\"lastName\": \"Swift\",\"className\":\"5A\",\"nationality\": \"Spain\"} |

Scenario: Update Student record
When Send a PUT HTTP request to endpoint "/student"
	|	{"id":@id,"className":"6A","nationality":"France"}|
Then I receive valid Response

Scenario: Get Student record by ID
When Send a GET HTTP request by ID to endpoint "/fetchStudents?Id="
Then I receive valid Response

Scenario: Get Student record by CLASS
When Send a GET HTTP request by Class "8A" to endpoint "/fetchStudents?class=" 
Then I receive valid Response

Scenario: Get All Student record
When Send a GET HTTP request to endpoint "/student"
Then I receive valid Response

Scenario: Delete Student record
When Send a DELETE HTTP request to endpoint "/student" 
Then I receive valid Response