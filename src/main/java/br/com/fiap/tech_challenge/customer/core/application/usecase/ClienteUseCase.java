package br.com.fiap.tech_challenge.customer.core.application.usecase;

import br.com.fiap.tech_challenge.customer.adapters.driver.controller.model.request.AtualizarClienteDTO;
import br.com.fiap.tech_challenge.customer.adapters.driver.controller.model.request.CadastrarClienteDTO;
import br.com.fiap.tech_challenge.customer.core.domain.model.Cliente;

public interface ClienteUseCase {
    void cadastrarCliente(CadastrarClienteDTO cadastrar);
    Cliente buscarClientePorCPF(String cpf);
    void atualizarCliente(AtualizarClienteDTO atualizar);
    String excluirCliente(Long id);
}
