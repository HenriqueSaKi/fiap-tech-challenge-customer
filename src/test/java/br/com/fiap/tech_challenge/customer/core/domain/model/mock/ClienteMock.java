package br.com.fiap.tech_challenge.customer.core.domain.model.mock;

import br.com.fiap.tech_challenge.customer.core.domain.model.Cliente;

import java.util.ArrayList;

public class ClienteMock {

  public static Cliente getMock() {
    Cliente cliente = new Cliente();
    cliente.setId(1L);
    cliente.setCpf("123.456.789/10");
    cliente.setPrimeiroNome("Teste");
    cliente.setSobrenome("Mockito");
    cliente.setEmail("teste@teste.com");
    cliente.setEnderecos(new ArrayList<>());
    cliente.getEnderecos().add(EnderecoMock.getMock());
    cliente.setTelefones(new ArrayList<>());
    cliente.getTelefones().add(TelefoneMock.getMock());

    return cliente;
  }

}
