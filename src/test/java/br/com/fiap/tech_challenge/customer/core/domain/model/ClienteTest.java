package br.com.fiap.tech_challenge.customer.core.domain.model;

import br.com.fiap.tech_challenge.customer.adapters.driver.controller.model.request.AtualizarClienteDTO;
import br.com.fiap.tech_challenge.customer.adapters.driver.controller.request.mock.AtualizarClienteDTOMock;
import br.com.fiap.tech_challenge.customer.core.domain.exception.DomainException;
import br.com.fiap.tech_challenge.customer.core.domain.model.mock.ClienteMock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

  @Test
  public void testCliente() {
    Cliente cliente = ClienteMock.getMock();
    assertEquals(1L, cliente.getId());
    assertNotEquals("123.456.789/10", cliente.getCpf());
    assertEquals("12345678910", cliente.getCpf());
    assertEquals("Teste", cliente.getPrimeiroNome());
    assertEquals("Mockito", cliente.getSobrenome());
    assertEquals("teste@teste.com", cliente.getEmail());
    assertFalse(cliente.getEnderecos().isEmpty());
    assertFalse(cliente.getTelefones().isEmpty());
  }

  @Test
  public void testValidarDadosAtualizacao_invalidCpf() {
    Cliente cliente = ClienteMock.getMock();
    AtualizarClienteDTO atualizarClienteDTO = AtualizarClienteDTOMock.getMock();
    atualizarClienteDTO.setCpf("123.123.123/12");
    assertEquals("Não é possível alterar cpf de cliente já existente",
        assertThrows(DomainException.class, () -> cliente.validarDadosAtualizacao(atualizarClienteDTO))
            .getMessage());
  }

  @Test
  public void testValidarDadosAtualizacao_invalidEmail() {
    Cliente cliente = ClienteMock.getMock();
    AtualizarClienteDTO atualizarClienteDTO = AtualizarClienteDTOMock.getMock();
    atualizarClienteDTO.setEmail("abcdefg@@@teste.com");
    assertEquals("E-mail inválido!",
        assertThrows(DomainException.class, () -> cliente.validarDadosAtualizacao(atualizarClienteDTO))
            .getMessage());
  }


}
