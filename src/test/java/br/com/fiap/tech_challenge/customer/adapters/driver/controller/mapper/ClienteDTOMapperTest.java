package br.com.fiap.tech_challenge.customer.adapters.driver.controller.mapper;

import br.com.fiap.tech_challenge.customer.adapters.driver.controller.request.mock.AtualizarClienteDTOMock;
import br.com.fiap.tech_challenge.customer.adapters.driver.controller.request.mock.CadastrarClienteDTOMock;
import br.com.fiap.tech_challenge.customer.core.domain.model.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ClienteDTOMapperTest {

  private ClienteDTOMapper mapper;

  @BeforeEach
  public void setUp() {
    mapper = new ClienteDTOMapperImpl();
  }

  @Test
  public void testCadastrarToCliente() {
    Cliente cliente = mapper.cadastrarToCliente(CadastrarClienteDTOMock.getMock());
    assertNotNull(cliente);
    assertNull(cliente.getId());
  }

  @Test
  public void testCadastrarToCliente_whenCadastrarIsNull() {
    assertNull(mapper.cadastrarToCliente(null));
  }

  @Test
  public void testAtualizarToCliente() {
    Cliente cliente = mapper.atualizarToCliente(AtualizarClienteDTOMock.getMock());
    assertNotNull(cliente);
    assertNotNull(cliente.getId());
  }

  @Test
  public void testAtualizarToCliente_whenAtualizarIsNull() {
    assertNull(mapper.atualizarToCliente(null));
  }

}
