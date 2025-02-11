package br.com.fiap.tech_challenge.customer;

import br.com.fiap.tech_challenge.customer.adapters.driven.infrastructure.repository.ClienteRepository;
import br.com.fiap.tech_challenge.customer.adapters.driven.infrastructure.repository.entity.ClienteEntity;
import br.com.fiap.tech_challenge.customer.adapters.driven.infrastructure.repository.entity.mock.ClienteEntityMock;
import br.com.fiap.tech_challenge.customer.adapters.driver.controller.model.request.AtualizarClienteDTO;
import br.com.fiap.tech_challenge.customer.adapters.driver.controller.request.mock.AtualizarClienteDTOMock;
import br.com.fiap.tech_challenge.customer.client.CucumberClient;
import feign.FeignException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AtualizarClienteStepDefinitions {

  @Autowired private CucumberClient cucumberClient;
  @Autowired private ClienteRepository repository;
  private ResponseEntity<String> response;
  private AtualizarClienteDTO atualizarClienteDTO = AtualizarClienteDTOMock.getMock();

  @Given("that I have a customer to be updated")
  public void that_i_have_a_customer_to_be_updated() {
    repository.save(ClienteEntityMock.getMock());
  }

  @When("I try to modify properly a customer data")
  public void i_try_to_modify_properly_a_customer_data() {
    try {
      response = cucumberClient.atualizarCliente(atualizarClienteDTO);
    } catch (FeignException.NotFound e) {
      response = ResponseEntity.status(e.status()).body(e.contentUTF8());
    }
  }

  @Then("I should receive the message {string} for try to update customer data")
  public void i_should_receive_the_message_for_try_to_update_customer_data(String expectedMessage) {
    assertEquals(expectedMessage, response.getBody());
  }
  @And("Update response Http Status should be {int}")
  public void update_response_http_status_should_be(Integer httpStatus) {
    assertEquals(HttpStatusCode.valueOf(httpStatus), response.getStatusCode());
  }

}
