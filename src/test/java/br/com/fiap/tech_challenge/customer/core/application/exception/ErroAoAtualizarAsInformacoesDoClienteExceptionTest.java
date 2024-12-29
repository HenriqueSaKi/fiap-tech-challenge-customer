package br.com.fiap.tech_challenge.customer.core.application.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ErroAoAtualizarAsInformacoesDoClienteExceptionTest {

  @Test
  public void testException() {
    Exception exception = assertThrows(ErroAoAtualizarAsInformacoesDoClienteException.class,
        () -> { throw new ErroAoAtualizarAsInformacoesDoClienteException("Teste"); });

    assertInstanceOf(RuntimeException.class, exception);
    assertEquals("Teste", exception.getMessage());

  }

}
