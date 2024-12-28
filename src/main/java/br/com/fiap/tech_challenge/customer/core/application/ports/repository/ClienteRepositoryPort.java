package br.com.fiap.tech_challenge.customer.core.application.ports.repository;

import br.com.fiap.tech_challenge.customer.adapters.driven.infrastructure.repository.entity.ClienteEntity;

import java.util.Optional;

public interface ClienteRepositoryPort {
    Optional<ClienteEntity> findById(Long id);
    Optional<ClienteEntity> buscarPorCpf(String cpf);
    void save(ClienteEntity cliente);
    boolean existsById(Long id);
    void excluirPorId(Long id);

}
