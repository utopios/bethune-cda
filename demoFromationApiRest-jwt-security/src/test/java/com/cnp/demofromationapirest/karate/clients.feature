Feature: Test clients Controller
  Background:
    * def baseUrl = 'http://localhost:8080'
  Scenario: récupérer la totalité des clients
    Given url baseUrl + '/api/v1/clients'
    When method GET
    Then status 200
  Scenario: récupérer le client 1
    Given url baseUrl + '/api/v1/clients/1'
    When method GET
    Then status 200
    And match $.id == '1'
  Scenario: Ajouter un client
    Given url baseUrl + '/api/v1/clients'
    And request {nom: 'abadi', prenom : 'ihab', telephone : '0123456789'}
    When method POST
    Then status 200
    And match $.id == "#notnull"
