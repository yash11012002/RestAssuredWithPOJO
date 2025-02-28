Feature: Verify HTTP Request
  Scenario: Verify scenario
    Given user set endpoint "/users"
    When user set header "Content-Type" to "application/json"
    And  set body "createBody.json"
    When user call post HTTP request
    Then verify status code 201
    When user store "id" into "config.id"
    Then verify "id" is same as "config.id"
    When user set endpoint with id "/users/"
    And set request body from file "createBody.json" with "name" value "Yash ki chedh"
    When user call put HTTP request
    Then verify status code 200
    And verify response schema is same as "put_response_schema.json"
    When user call delete HTTP request
    Then verify status code 200
    When user call get HTTP request
    Then verify status code 404
