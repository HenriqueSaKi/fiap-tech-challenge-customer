package br.com.fiap.tech_challenge.customer.core.application.constant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteExceptionConstanteTest {

  @Test
  public void testClienteJaCadastradoException() {
    assertEquals("Este cliente já foi cadastrado.", ClienteExceptionConstante.CLIENTE_JA_CADASTRADO_EXCEPTION);
  }

  @Test
  public void testClienteNaoEncontradoException() {
    assertEquals("Não foi encontrado nenhum cliente com o ID informado.", ClienteExceptionConstante.CLIENTE_NAO_ENCONTRADO_EXCEPTION);
  }

  @Test
  public void testErroAoCadastrarClienteException() {
    assertEquals("Ocorreu um erro inesperado na hora de cadastrar o cliente.", ClienteExceptionConstante.ERRO_AO_CADASTRAR_CLIENTE_EXCEPTION);
  }

  @Test
  public void testErroAoAtualizarAsInformacoesDoClienteException() {
    assertEquals("Erro ao atualizar as informações do cliente.", ClienteExceptionConstante.ERRO_AO_ATUALIZAR_AS_INFORMACOES_DO_CLIENTE_EXCEPTION);
  }

  @Test
  public void testErroAoExcluirClienteException() {
    assertEquals("Ocorreu um erro inesperado durante a exclusão do cliente.", ClienteExceptionConstante.ERRO_AO_EXCLUIR_CLIENTE_EXCEPTION);
  }

}
