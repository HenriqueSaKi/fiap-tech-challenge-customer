package br.com.fiap.tech_challenge.customer.core.application.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ErroAoCadastrarClienteExceptionTest {

  @Test
  public void testException() {
    Exception exception = assertThrows(ErroAoCadastrarClienteException.class,
        () -> { throw new ErroAoCadastrarClienteException("Teste"); });

    assertInstanceOf(RuntimeException.class, exception);
    assertEquals("Teste", exception.getMessage());

  }

}
