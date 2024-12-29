package br.com.fiap.tech_challenge.customer.adapters.driven.infrastructure.repository.entity.mock;

import br.com.fiap.tech_challenge.customer.adapters.driven.infrastructure.repository.entity.EnderecoEntity;

public class EnderecoEntityMock {
  
  public static EnderecoEntity getMock() {
    EnderecoEntity endereco = new EnderecoEntity();
    endereco.setCep("12345-123");
    endereco.setLogradouro("Rua exemplo, 123");
    endereco.setComplemento("Bloco A, Apto 123");
    endereco.setBairro("Vila Exemplo");
    endereco.setCidade("São Paulo");
    endereco.setEstado("SP");
    return endereco;
  }
  
}
