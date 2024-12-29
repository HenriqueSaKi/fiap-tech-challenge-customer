package br.com.fiap.tech_challenge.customer.core.application.mapper;

import br.com.fiap.tech_challenge.customer.adapters.driven.infrastructure.repository.entity.ClienteEntity;
import br.com.fiap.tech_challenge.customer.adapters.driven.infrastructure.repository.entity.mock.ClienteEntityMock;
import br.com.fiap.tech_challenge.customer.core.domain.model.Cliente;
import br.com.fiap.tech_challenge.customer.core.domain.model.mock.ClienteMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ClienteMapperTest {

  private ClienteMapper mapper;

  @BeforeEach
  public void setUp() {
    mapper = new ClienteMapperImpl();
  }

  @Test
  public void testToCliente() {
    Cliente cliente = mapper.toCliente(ClienteEntityMock.getMock());
    assertNotNull(cliente);
  }

  @Test
  public void testToCliente_whenClienteEntityIsNull() {
    assertNull(mapper.toCliente(null));
  }

  @Test
  public void testToClienteEntity() {
    ClienteEntity cliente = mapper.toClienteEntity(ClienteMock.getMock());
    assertNotNull(cliente);
  }

  @Test
  public void testToClienteEntity_whenClienteIsNull() {
    assertNull(mapper.toClienteEntity(null));
  }

}
