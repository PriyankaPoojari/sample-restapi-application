#Author: Priyanka Poojari

@NegativeFlows
Feature: Test CRUD methods in StudentsApp REST API functionality by providing INVALID DATA
Description: The purpose of this test is to invalidate happy flow of the API's

Background:
	Given I set Base url
	And I Set request HEADER

Scenario Outline: Add Student record- Negative
When Send a POST HTTP request to "<Endpoint>" and "<RequestBody>"
Then I receive invalid Response
Examples:
	|	Endpoint | RequestBody |
	|	/student | {\"id\":@id,\"firstName\": \"Mike\",\"lastName\": \"Wong\",\"className\":\"3 A\",\"nationality\": \"\"}|

Scenario: Update Student record
When Send a PUT HTTP request to endpoint "/student"
	|	{"id":00000,"className":"6A"}|
Then I receive invalid Response

Scenario: Get Student record by ID
When Send a GET HTTP request by ID to endpoint "/fetchStudents?Id="
Then I receive invalid Response

Scenario: Get Student record by CLASS
When Send a GET HTTP request by Class "ABC10" to endpoint "/fetchStudents?class="
Then I receive invalid Response

Scenario: Delete Student record
When Send a DELETE HTTP request to endpoint "/student" 
Then I receive invalid Response