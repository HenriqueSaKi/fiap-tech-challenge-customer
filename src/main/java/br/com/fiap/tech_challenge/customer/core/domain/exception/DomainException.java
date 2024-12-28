package br.com.fiap.tech_challenge.customer.core.domain.exception;

public class DomainException extends RuntimeException {
  public DomainException(String message) {
    super(message);
  }
}
