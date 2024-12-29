package br.com.fiap.tech_challenge.customer.core.domain.model;

import br.com.fiap.tech_challenge.customer.core.domain.model.mock.EnderecoMock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class EnderecoTest {

  @Test
  public void testEndereco() {
    Endereco endereco = EnderecoMock.getMock();
    assertNotEquals("12345-123", endereco.getCep());
    assertEquals("Rua exemplo, 123", endereco.getLogradouro());
    assertEquals("Bloco A, Apto 123", endereco.getComplemento());
    assertEquals("Vila Exemplo", endereco.getBairro());
    assertEquals("São Paulo", endereco.getCidade());
    assertEquals("SP", endereco.getEstado());

  }

}
