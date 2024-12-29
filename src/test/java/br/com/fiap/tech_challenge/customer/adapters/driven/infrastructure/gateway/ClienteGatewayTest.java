package br.com.fiap.tech_challenge.customer.adapters.driven.infrastructure.gateway;

import br.com.fiap.tech_challenge.customer.adapters.driven.infrastructure.repository.ClienteRepository;
import br.com.fiap.tech_challenge.customer.adapters.driven.infrastructure.repository.entity.ClienteEntity;
import br.com.fiap.tech_challenge.customer.adapters.driven.infrastructure.repository.entity.mock.ClienteEntityMock;
import br.com.fiap.tech_challenge.customer.core.domain.model.Cliente;
import br.com.fiap.tech_challenge.customer.core.domain.model.mock.ClienteMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClienteGatewayTest {

  @Mock private ClienteRepository repository;
  @InjectMocks private ClienteGateway gateway;

  @Test
  public void whenFindByIdReturnClientEntity_thenReturnCliente() {
    when(repository.findById(1L)).thenReturn(Optional.of(ClienteEntityMock.getMock()));
    Cliente cliente = gateway.findById(1L);
    assertNotNull(cliente);

    verify(repository, times(1)).findById(any());
  }

  @Test
  public void whenFindByIdReturnEmptyClientEntity_thenReturnNull() {
    when(repository.findById(any())).thenReturn(Optional.empty());
    Cliente cliente = gateway.findById(1L);
    assertNull(cliente);

    verify(repository, times(1)).findById(any());
  }

  @Test
  public void whenFindByCpfReturnClientEntity_thenReturnCliente() {
    String cpf = "12345678910";
    when(repository.findByCpf(cpf)).thenReturn(Optional.of(ClienteEntityMock.getMock()));
    Cliente cliente = gateway.buscarPorCpf(cpf);
    assertNotNull(cliente);

    verify(repository, times(1)).findByCpf(any());
  }

  @Test
  public void whenFindByCpfReturnEmptyClientEntity_thenReturnNull() {
    when(repository.findByCpf(any())).thenReturn(Optional.empty());
    Cliente cliente = gateway.buscarPorCpf("12345678910");
    assertNull(cliente);

    verify(repository, times(1)).findByCpf(any());
  }

  @Test
  public void whenSaveClient_thenVerifyIfSaveMethodWasExecuted() throws Exception {
    gateway.save(ClienteMock.getMock());
    verify(repository, times(1)).save(any());
  }

  @Test
  public void whenSaveClientGoesWrong_thenThrowException() {
    assertThrows(Exception.class, () -> gateway.save(new Cliente()));
  }

  @Test
  public void whenExistsById_thenReturnTrue() {
    when(repository.existsById(1L)).thenReturn(true);
    assertTrue(gateway.existsById(1L));
  }

  @Test
  public void whenNotExistsById_thenReturnTrue() {
    when(repository.existsById(1L)).thenReturn(false);
    assertFalse(gateway.existsById(1L));
  }

  @Test
  public void whenExcluirPorId_thenVerifyIfDeleteByIdWasExecuted() {
    gateway.excluirPorId(1L);
    verify(repository, times(1)).deleteById(any());
  }

}
