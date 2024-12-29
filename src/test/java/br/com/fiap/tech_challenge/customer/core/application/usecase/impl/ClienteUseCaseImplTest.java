package br.com.fiap.tech_challenge.customer.core.application.usecase.impl;

import br.com.fiap.tech_challenge.customer.adapters.driver.controller.model.request.AtualizarClienteDTO;
import br.com.fiap.tech_challenge.customer.adapters.driver.controller.model.request.CadastrarClienteDTO;
import br.com.fiap.tech_challenge.customer.adapters.driver.controller.request.mock.AtualizarClienteDTOMock;
import br.com.fiap.tech_challenge.customer.adapters.driver.controller.request.mock.CadastrarClienteDTOMock;
import br.com.fiap.tech_challenge.customer.core.application.exception.*;
import br.com.fiap.tech_challenge.customer.core.application.ports.gateway.ClienteGatewayPort;
import br.com.fiap.tech_challenge.customer.core.application.usecase.ClienteUseCase;
import br.com.fiap.tech_challenge.customer.core.domain.exception.DomainException;
import br.com.fiap.tech_challenge.customer.core.domain.model.mock.ClienteMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClienteUseCaseImplTest {

  @InjectMocks private ClienteUseCaseImpl useCase;
  @Mock private ClienteGatewayPort gatewayPort;

  @Test
  public void testCadastrarCliente_whenBuscarPorCpfIsNotNull() {
    when(gatewayPort.buscarPorCpf(any())).thenReturn(ClienteMock.getMock());
    assertThrows(ClienteJaCadastradoException.class, () -> useCase.cadastrarCliente(new CadastrarClienteDTO()));
  }

  @Test
  public void testCadastrarCliente_whenBuscarPorCpfIsNull() throws Exception {
    when(gatewayPort.buscarPorCpf(any())).thenReturn(null);
    useCase.cadastrarCliente(CadastrarClienteDTOMock.getMock());

    verify(gatewayPort, times(1)).buscarPorCpf(any());
    verify(gatewayPort, times(1)).save(any());
  }

  @Test
  public void testCadastrarCliente_whenThrowException() throws Exception {
    when(gatewayPort.buscarPorCpf(any())).thenReturn(null);
    assertThrows(ErroAoCadastrarClienteException.class, () -> useCase.cadastrarCliente(new CadastrarClienteDTO()));
  }

  @Test
  public void testBuscarCliente_whenClienteIsNotNull() {
    when(gatewayPort.buscarPorCpf(any())).thenReturn(ClienteMock.getMock());
    assertNotNull(useCase.buscarClientePorCPF("123.456.789/10"));
  }

  @Test
  public void testBuscarCliente_whenClienteIsNull() {
    when(gatewayPort.buscarPorCpf(any())).thenReturn(null);
    assertThrows(ClienteNaoEncontradoException.class, () -> useCase.buscarClientePorCPF("123.456.789/10"));
  }

  @Test
  public void testAtualizarCliente_whenFindByIdIsNull() {
    when(gatewayPort.findById(any())).thenReturn(null);
    assertThrows(ClienteNaoEncontradoException.class, () -> useCase.atualizarCliente(AtualizarClienteDTOMock.getMock()));
  }

  @Test
  public void testAtualizarCliente_whenIsValidCliente() throws Exception {
    when(gatewayPort.findById(any())).thenReturn(ClienteMock.getMock());
    useCase.atualizarCliente(AtualizarClienteDTOMock.getMock());

    verify(gatewayPort, times(2)).findById(any());
    verify(gatewayPort, times(1)).save(any());
  }

  @Test
  public void testAtualizarCliente_whenThrowDomainException() throws Exception {
    when(gatewayPort.findById(any())).thenReturn(ClienteMock.getMock());
    doThrow(DomainException.class).when(gatewayPort).save(any());
    assertThrows(ErroAoAtualizarAsInformacoesDoClienteException.class, () -> useCase.atualizarCliente(AtualizarClienteDTOMock.getMock()));

    verify(gatewayPort, times(2)).findById(any());
    verify(gatewayPort, times(1)).save(any());
  }

  @Test
  public void testAtualizarCliente_whenThrowErroAoAtualizarAsInformacoesDoClienteException() throws Exception {
    when(gatewayPort.findById(any())).thenReturn(ClienteMock.getMock());
    doThrow(RuntimeException.class).when(gatewayPort).save(any());
    assertThrows(ErroAoAtualizarAsInformacoesDoClienteException.class, () -> useCase.atualizarCliente(AtualizarClienteDTOMock.getMock()));

    verify(gatewayPort, times(2)).findById(any());
    verify(gatewayPort, times(1)).save(any());
  }

  @Test
  public void testExcluirCliente_whenExistsByIdIsFalse() {
    when(gatewayPort.existsById(any())).thenReturn(false);
    assertThrows(ClienteNaoEncontradoException.class, () -> useCase.excluirCliente(1L));
  }

  @Test
  public void testExcluirCliente_whenExistsById() {
    when(gatewayPort.existsById(any())).thenReturn(true);
    assertEquals("Cliente excluído com sucesso!", useCase.excluirCliente(1L));

    verify(gatewayPort, times(1)).existsById(any());
  }

  @Test
  public void testExcluirCliente_whenThrowException() {
    when(gatewayPort.existsById(any())).thenReturn(true);
    doThrow(RuntimeException.class).when(gatewayPort).excluirPorId(any());
    assertThrows(ErroAoExcluirClienteException.class, () -> useCase.excluirCliente(1L));
  }

}
