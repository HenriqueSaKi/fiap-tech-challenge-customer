package br.com.fiap.tech_challenge.customer.core.application.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteNaoEncontradoExceptionTest {

  @Test
  public void testException() {
    Exception exception = assertThrows(ClienteNaoEncontradoException.class,
        () -> { throw new ClienteNaoEncontradoException("Teste"); });

    assertInstanceOf(RuntimeException.class, exception);
    assertEquals("Teste", exception.getMessage());

  }

  @Test
  public void testException_withCause() {
    Throwable cause = new Throwable("Cause");

    Exception exception = assertThrows(ClienteNaoEncontradoException.class,
        () -> { throw new ClienteNaoEncontradoException("Teste", cause); });

    assertInstanceOf(RuntimeException.class, exception);
    assertEquals("Teste", exception.getMessage());

  }

}
