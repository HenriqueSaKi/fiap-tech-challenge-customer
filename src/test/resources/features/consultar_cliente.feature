Feature: Consultar cliente por CPF
  What happens when I try to consult a customer?

  Scenario: Customer found
    Given that I have a customer registered
    When I try to consult customer "12345678910"
    Then should receive a non-null body
    And Consult customer Http Status should be 200

  Scenario: Customer not found
    Given that I have a customer registered
    When I try consult customer sending wrong document number
    Then I should receive the message "Não foi encontrado nenhum cliente com o ID informado." for consult customer
    And Consult customer Http Status should be 404