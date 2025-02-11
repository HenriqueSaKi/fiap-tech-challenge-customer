package br.com.fiap.tech_challenge.customer.adapters.driven.infrastructure.repository.entity.mock;

import br.com.fiap.tech_challenge.customer.adapters.driven.infrastructure.repository.entity.ClienteEntity;

import java.util.ArrayList;

public class ClienteEntityMock {

  public static ClienteEntity getMock() {
    ClienteEntity entity = new ClienteEntity();
    entity.setId(1L);
    entity.setCpf("12345678910");
    entity.setPrimeiroNome("Teste");
    entity.setSobrenome("Mockito");
    entity.setEmail("teste@teste.com");
    entity.setEnderecos(new ArrayList<>());
    entity.getEnderecos().add(EnderecoEntityMock.getMock());
    entity.setTelefones(new ArrayList<>());
    entity.getTelefones().add(TelefoneEntityMock.getMock());
    return entity;
  }

  public static ClienteEntity getMock2() {
    ClienteEntity entity = new ClienteEntity();
    entity.setId(2L);
    entity.setCpf("11345678911");
    entity.setPrimeiroNome("Teste2");
    entity.setSobrenome("Mockito2");
    entity.setEmail("teste2@teste.com");
    entity.setEnderecos(new ArrayList<>());
    entity.getEnderecos().add(EnderecoEntityMock.getMock());
    entity.setTelefones(new ArrayList<>());
    entity.getTelefones().add(TelefoneEntityMock.getMock());
    return entity;
  }

}
