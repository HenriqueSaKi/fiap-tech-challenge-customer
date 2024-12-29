package br.com.fiap.tech_challenge.customer.adapters.driver.controller.request.mock;

import br.com.fiap.tech_challenge.customer.adapters.driver.controller.model.request.CadastrarClienteDTO;
import br.com.fiap.tech_challenge.customer.core.domain.model.Cliente;

import java.util.ArrayList;

public class CadastrarClienteDTOMock {

  public static CadastrarClienteDTO getMock() {
    CadastrarClienteDTO cadastrar = new CadastrarClienteDTO();
    cadastrar.setCpf("12345678910");
    cadastrar.setPrimeiroNome("Teste");
    cadastrar.setSobrenome("Mockito");
    cadastrar.setEmail("teste@teste.com");
    cadastrar.setEnderecos(new ArrayList<>());
    cadastrar.getEnderecos().add(EnderecoDTOMock.getMock());
    cadastrar.setTelefones(new ArrayList<>());
    cadastrar.getTelefones().add(TelefoneDTOMock.getMock());
    return cadastrar;
  }

}
