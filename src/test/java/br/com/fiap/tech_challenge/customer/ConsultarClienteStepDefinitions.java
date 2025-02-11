package br.com.fiap.tech_challenge.customer;

import br.com.fiap.tech_challenge.customer.adapters.driven.infrastructure.repository.ClienteRepository;
import br.com.fiap.tech_challenge.customer.adapters.driven.infrastructure.repository.entity.mock.ClienteEntityMock;
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
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConsultarClienteStepDefinitions {

  @Autowired
  private CucumberClient cucumberClient;
  @Autowired private ClienteRepository repository;
  private ResponseEntity<Object> response;

  @Given("that I have a customer registered")
  public void that_i_have_a_customer_registered() {
    repository.save(ClienteEntityMock.getMock());
  }
  @When("I try to consult customer {string}")
  public void i_try_to_consult_customer(String documentNumber) {
    try {
      response = cucumberClient.buscarClientePorCPF(documentNumber);
    } catch (FeignException.BadRequest e) {
      response = ResponseEntity.status(e.status()).body(e.contentUTF8());
    }
  }

  @When("I try consult customer sending wrong document number")
  public void i_try_consult_customer_sending_wrong_document_number() {
    try {
      response = cucumberClient.buscarClientePorCPF("12312312312");
    } catch (FeignException.NotFound e) {
      response = ResponseEntity.status(e.status()).body(e.contentUTF8());
    }
  }

  @Then("I should receive the message {string} for consult customer")
  public void i_should_receive_the_message_for_consult_customer(String expectedMessage) {
    assertEquals(expectedMessage, response.getBody());
  }

  @Then("should receive a non-null body")
  public void should_receive_a_non_null_body() {
    assertNotNull(response.getBody());
  }
  @And("Consult customer Http Status should be {int}")
  public void consult_customer_http_status_should_be(Integer httpStatus) {
    assertEquals(HttpStatusCode.valueOf(httpStatus), response.getStatusCode());
  }

}
