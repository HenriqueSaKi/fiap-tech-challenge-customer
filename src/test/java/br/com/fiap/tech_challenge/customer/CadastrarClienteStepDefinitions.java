package br.com.fiap.tech_challenge.customer;

import br.com.fiap.tech_challenge.customer.adapters.driven.infrastructure.repository.ClienteRepository;
import br.com.fiap.tech_challenge.customer.adapters.driven.infrastructure.repository.entity.mock.ClienteEntityMock;
import br.com.fiap.tech_challenge.customer.adapters.driver.controller.model.request.CadastrarClienteDTO;
import br.com.fiap.tech_challenge.customer.adapters.driver.controller.request.mock.CadastrarClienteDTOMock;
import br.com.fiap.tech_challenge.customer.client.CucumberClient;
import feign.FeignException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
public class CadastrarClienteStepDefinitions {

  @Autowired private CucumberClient cucumberClient;
  @Autowired private ClienteRepository repository;
  private CadastrarClienteDTO cadastrarClienteDTO;
  private ResponseEntity<String> response;

  @Given("that I'm a new customer")
  public void that_i_m_a_new_customer() {
    cadastrarClienteDTO = CadastrarClienteDTOMock.getMock();
  }

  @Given("that I'm not a new customer")
  public void that_i_m_not_a_new_customer() {
    repository.save(ClienteEntityMock.getMock());
    cadastrarClienteDTO = CadastrarClienteDTOMock.getMock();
  }

  @When("I try to register my customer data")
  public void i_try_to_register_my_customer_data() {
    try {
      response = cucumberClient.cadastrarCliente(cadastrarClienteDTO);
    } catch (FeignException.BadRequest e) {
      response = ResponseEntity.status(e.status()).body(e.contentUTF8());
    }
  }
  @Then("I should receive the message {string}")
  public void i_should_receive_the_message(String expectedMessage) {
    assertEquals(expectedMessage, response.getBody());
  }

}
