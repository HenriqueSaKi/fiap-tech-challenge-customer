Feature: Excluir cliente
  What happens when I try to delete customer from database?

  Scenario: Customer deleted successfully
    Given that I have a customer to be deleted
    When I try to delete customer data
    Then I should receive the message "Cliente excluído com sucesso!" for delete customer successfully
    And Delete Response Http Status is equal to 200