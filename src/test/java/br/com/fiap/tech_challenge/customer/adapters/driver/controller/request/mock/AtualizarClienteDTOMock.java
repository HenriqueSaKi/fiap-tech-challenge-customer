package br.com.fiap.tech_challenge.customer.adapters.driver.controller.request.mock;

import br.com.fiap.tech_challenge.customer.adapters.driver.controller.model.request.AtualizarClienteDTO;

import java.util.ArrayList;

public class AtualizarClienteDTOMock {

  public static AtualizarClienteDTO getMock() {
    AtualizarClienteDTO atualizar = new AtualizarClienteDTO();
    atualizar.setId(1L);
    atualizar.setCpf("123.456.789/10");
    atualizar.setPrimeiroNome("Teste");
    atualizar.setSobrenome("Mockito");
    atualizar.setEmail("teste@teste.com");
    atualizar.setEnderecos(new ArrayList<>());
    atualizar.getEnderecos().add(EnderecoDTOMock.getMock());
    atualizar.setTelefones(new ArrayList<>());
    atualizar.getTelefones().add(TelefoneDTOMock.getMock());
    return atualizar;
  }

}
