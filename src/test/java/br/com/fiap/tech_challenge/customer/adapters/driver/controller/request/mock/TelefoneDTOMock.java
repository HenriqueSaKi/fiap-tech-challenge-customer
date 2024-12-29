package br.com.fiap.tech_challenge.customer.adapters.driver.controller.request.mock;

import br.com.fiap.tech_challenge.customer.adapters.driver.controller.model.enums.TipoTelefone;
import br.com.fiap.tech_challenge.customer.adapters.driver.controller.model.request.TelefoneDTO;

public class TelefoneDTOMock {

  public static TelefoneDTO getMock() {
    TelefoneDTO telefone = new TelefoneDTO();
    telefone.setTipoTelefone(TipoTelefone.CELULAR);
    telefone.setDdd("11");
    telefone.setNumero("91234-1234");
    return telefone;
  }

}
