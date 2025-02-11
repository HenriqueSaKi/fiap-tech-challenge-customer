package br.com.fiap.tech_challenge.customer;

import br.com.fiap.tech_challenge.customer.adapters.driven.infrastructure.repository.ClienteRepository;
import br.com.fiap.tech_challenge.customer.adapters.driven.infrastructure.repository.entity.mock.ClienteEntityMock;
import br.com.fiap.tech_challenge.customer.client.CucumberClient;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExcluirClienteStepDefinitions {

  @Autowired private CucumberClient cucumberClient;
  @Autowired private ClienteRepository repository;
  private ResponseEntity<String> response;

  @Given("that I have a customer to be deleted")
  public void that_i_have_a_customer_to_be_deleted() {
    repository.save(ClienteEntityMock.getMock());
  }
  @When("I try to delete customer data")
  public void i_try_to_delete_customer_data() {
    response = cucumberClient.excluirCliente(1L);
  }

  @Then("I should receive the message {string} for delete customer successfully")
  public void i_should_receive_the_message_for_delete_customer_successfully(String expectedMessage) {
    assertEquals(expectedMessage, response.getBody());
  }
  @And("Delete Response Http Status is equal to {int}")
  public void delete_response_http_status_is_equal_to(Integer httpStatus) {
    assertEquals(HttpStatusCode.valueOf(httpStatus), response.getStatusCode());
  }

}
