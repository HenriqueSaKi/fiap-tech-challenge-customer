package br.com.fiap.tech_challenge.customer.core.application.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ErroAoExcluirClienteExceptionTest {

  @Test
  public void testException() {
    Exception exception = assertThrows(ErroAoExcluirClienteException.class,
        () -> { throw new ErroAoExcluirClienteException("Teste"); });

    assertInstanceOf(RuntimeException.class, exception);
    assertEquals("Teste", exception.getMessage());

  }

}
