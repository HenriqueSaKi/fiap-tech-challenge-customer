package br.com.fiap.tech_challenge.customer.adapters.driven.infrastructure.repository.entity.mock;

import br.com.fiap.tech_challenge.customer.adapters.driven.infrastructure.repository.entity.TelefoneEntity;
import br.com.fiap.tech_challenge.customer.core.domain.model.enums.TipoTelefone;

public class TelefoneEntityMock {

  public static TelefoneEntity getMock() {
    TelefoneEntity telefone = new TelefoneEntity();
    telefone.setTipoTelefone(TipoTelefone.CELULAR);
    telefone.setDdd("11");
    telefone.setNumero("912341234");
    return telefone;
  }

}
