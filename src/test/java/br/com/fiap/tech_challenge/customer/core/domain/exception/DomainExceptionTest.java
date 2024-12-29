package br.com.fiap.tech_challenge.customer.core.domain.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DomainExceptionTest {

  @Test
  public void testException() {
    Exception exception = assertThrows(DomainException.class,
        () -> { throw new DomainException("Teste"); });

    assertInstanceOf(RuntimeException.class, exception);
    assertEquals("Teste", exception.getMessage());

  }

}
