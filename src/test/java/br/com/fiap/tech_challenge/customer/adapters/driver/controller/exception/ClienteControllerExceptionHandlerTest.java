package br.com.fiap.tech_challenge.customer.adapters.driver.controller.exception;

import br.com.fiap.tech_challenge.customer.core.application.exception.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static br.com.fiap.tech_challenge.customer.core.application.constant.ClienteExceptionConstante.ERRO_AO_ATUALIZAR_AS_INFORMACOES_DO_CLIENTE_EXCEPTION;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ClienteControllerExceptionHandlerTest {

  private ClienteControllerExceptionHandler handler;

  @BeforeEach
  public void setUp() {
    handler = new ClienteControllerExceptionHandler();
  }

  @Test
  public void testClienteJaCadastradoException() {
    ClienteJaCadastradoException clienteJaCadastradoException = new ClienteJaCadastradoException("Teste");
    ResponseEntity<String> response = handler.clienteJaCadastradoException(clienteJaCadastradoException);

    assertNotNull(response);
    assertEquals("Teste", response.getBody());
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
  }

  @Test
  public void testClienteNaoEncontradoException() {
    ClienteNaoEncontradoException clienteNaoEncontradoException = new ClienteNaoEncontradoException("Teste");
    ResponseEntity<String> response = handler.clienteNaoEncontradoException(clienteNaoEncontradoException);

    assertNotNull(response);
    assertEquals("Teste", response.getBody());
    assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
  }

  @Test
  public void testErroAoCadastrarClienteException() {
    ErroAoCadastrarClienteException erroAoCadastrarClienteException = new ErroAoCadastrarClienteException("Teste");
    ResponseEntity<String> response = handler.erroAoCadastrarClienteException(erroAoCadastrarClienteException);

    assertNotNull(response);
    assertEquals("Teste", response.getBody());
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
  }

  @Test
  public void internalServerError_whenErroAoAtualizarAsInformacoesDoClienteException() {
    ErroAoAtualizarAsInformacoesDoClienteException erroAoAtualizarAsInformacoesDoClienteException = new ErroAoAtualizarAsInformacoesDoClienteException(ERRO_AO_ATUALIZAR_AS_INFORMACOES_DO_CLIENTE_EXCEPTION);
    ResponseEntity<String> response = handler.erroAoAtualizarAsInformacoesDoClienteException(erroAoAtualizarAsInformacoesDoClienteException);

    assertNotNull(response);
    assertEquals(ERRO_AO_ATUALIZAR_AS_INFORMACOES_DO_CLIENTE_EXCEPTION, response.getBody());
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
  }

  @Test
  public void badRequest_whenErroAoAtualizarAsInformacoesDoClienteException() {
    ErroAoAtualizarAsInformacoesDoClienteException erroAoAtualizarAsInformacoesDoClienteException = new ErroAoAtualizarAsInformacoesDoClienteException("Teste");
    ResponseEntity<String> response = handler.erroAoAtualizarAsInformacoesDoClienteException(erroAoAtualizarAsInformacoesDoClienteException);

    assertNotNull(response);
    assertEquals("Teste", response.getBody());
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
  }

  @Test
  public void testErroAoExcluirClienteException() {
    ErroAoExcluirClienteException erroAoExcluirClienteException = new ErroAoExcluirClienteException("Teste");
    ResponseEntity<String> response = handler.erroAoExcluirClienteException(erroAoExcluirClienteException);

    assertNotNull(response);
    assertEquals("Teste", response.getBody());
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
  }

}
