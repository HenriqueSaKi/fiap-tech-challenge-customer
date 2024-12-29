package br.com.fiap.tech_challenge.customer.adapters.driver.controller.request.mock;

import br.com.fiap.tech_challenge.customer.adapters.driver.controller.model.request.EnderecoDTO;

public class EnderecoDTOMock {
  
  public static EnderecoDTO getMock() {
    EnderecoDTO endereco = new EnderecoDTO();
    endereco.setCep("12345-123");
    endereco.setLogradouro("Rua exemplo, 123");
    endereco.setComplemento("Bloco A, Apto 123");
    endereco.setBairro("Vila Exemplo");
    endereco.setCidade("São Paulo");
    endereco.setEstado("SP");
    return endereco;
  }
  
}
