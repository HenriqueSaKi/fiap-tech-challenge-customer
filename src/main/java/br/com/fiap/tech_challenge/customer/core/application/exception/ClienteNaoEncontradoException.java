package br.com.fiap.tech_challenge.customer.core.application.exception;

public class ClienteNaoEncontradoException extends RuntimeException{
    public ClienteNaoEncontradoException(String message) {
        super(message);
    }

    public ClienteNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }
}
