package br.com.fiap.tech_challenge.customer.steps;

import br.com.fiap.tech_challenge.customer.adapters.driver.controller.model.request.CadastrarClienteDTO;
import br.com.fiap.tech_challenge.customer.adapters.driver.controller.request.mock.CadastrarClienteDTOMock;
import br.com.fiap.tech_challenge.customer.client.CucumberClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Transactional
public class CadastrarClienteStepDefinitions {

  @Autowired private CucumberClient cucumberClient;
  private CadastrarClienteDTO cadastrarClienteDTO;
  private ResponseEntity<Object> response;

  @Given("that I'm a new customer")
  public void that_i_m_a_new_customer() {
    cadastrarClienteDTO = CadastrarClienteDTOMock.getMock();
  }

  @Given("that I'm not a new customer")
  public void that_i_m_not_a_new_customer() {
    cadastrarClienteDTO = CadastrarClienteDTOMock.getMock();
  }

  @When("I try to register my customer data")
  public void i_try_to_register_my_customer_data() {
    response = cucumberClient.cadastrarCliente(cadastrarClienteDTO);
  }
  @Then("I should receive the message {string}")
  public void i_should_receive_the_message(String expectedMessage) {
    assertEquals(expectedMessage, response.getBody());
  }

}
