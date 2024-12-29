package br.com.fiap.tech_challenge.customer.core.domain.model.mock;

import br.com.fiap.tech_challenge.customer.core.domain.model.Endereco;

public class EnderecoMock {
  
  public static Endereco getMock() {
    Endereco endereco = new Endereco();
    endereco.setCep("12345-123");
    endereco.setLogradouro("Rua exemplo, 123");
    endereco.setComplemento("Bloco A, Apto 123");
    endereco.setBairro("Vila Exemplo");
    endereco.setCidade("São Paulo");
    endereco.setEstado("SP");
    return endereco;
  }
  
}
