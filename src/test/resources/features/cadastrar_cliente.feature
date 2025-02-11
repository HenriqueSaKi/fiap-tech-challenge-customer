Feature: Cadastrar cliente
  What happens when I try to register a customer?

  Scenario: Customer saved successfully
    Given that I'm a new customer
    When I try to register my customer data
    Then I should receive the message "Cliente cadastrado com sucesso!"

  Scenario: Customer already exists
    Given that I'm not a new customer
    When I try to register my customer data
    Then I should receive the message "Este cliente já foi cadastrado."