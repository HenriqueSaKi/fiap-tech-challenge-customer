package br.com.fiap.tech_challenge.customer.core.domain.model.mock;

import br.com.fiap.tech_challenge.customer.core.domain.model.Telefone;
import br.com.fiap.tech_challenge.customer.core.domain.model.enums.TipoTelefone;

public class TelefoneMock {

  public static Telefone getMock() {
    Telefone telefone = new Telefone();
    telefone.setTipoTelefone(TipoTelefone.CELULAR);
    telefone.setDdd("11");
    telefone.setNumero("91234-1234");
    return telefone;
  }

}
