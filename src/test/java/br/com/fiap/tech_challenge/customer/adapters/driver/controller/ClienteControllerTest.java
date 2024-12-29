package br.com.fiap.tech_challenge.customer.adapters.driver.controller;

import br.com.fiap.tech_challenge.customer.adapters.driven.infrastructure.repository.ClienteRepository;
import br.com.fiap.tech_challenge.customer.adapters.driven.infrastructure.repository.entity.ClienteEntity;
import br.com.fiap.tech_challenge.customer.adapters.driven.infrastructure.repository.entity.mock.ClienteEntityMock;
import br.com.fiap.tech_challenge.customer.adapters.driver.controller.model.request.AtualizarClienteDTO;
import br.com.fiap.tech_challenge.customer.adapters.driver.controller.request.mock.AtualizarClienteDTOMock;
import br.com.fiap.tech_challenge.customer.adapters.driver.controller.request.mock.CadastrarClienteDTOMock;
import br.com.fiap.tech_challenge.customer.core.domain.model.mock.ClienteMock;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ClienteControllerTest {

  @InjectMocks private ClienteController controller;
  @Mock private ClienteRepository repository;
  private MockMvc mockMvc;

  @BeforeEach
  public void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(controller)
        .alwaysDo(print())
        .build();
  }

  @Test
  public void testCadastrarCliente() throws Exception {
    mockMvc.perform(
        post("/cliente")
            .contentType("application/json")
            .content(new Gson().toJson(CadastrarClienteDTOMock.getMock()))
        )
        .andExpect(status().isCreated());
  }

  @Test
  public void testBuscarClientePorCpf() throws Exception {
    when(repository.findByCpf("12345678910")).thenReturn(Optional.of(ClienteEntityMock.getMock()));

    mockMvc.perform(get("/cliente/{cpf}", "12345678910"))
        .andExpect(status().isOk());
  }

  @Test
  public void testAtualizarCliente() throws Exception {
    ClienteEntity entity = ClienteEntityMock.getMock();
    entity.setEnderecos(new ArrayList<>());
    entity.setTelefones(new ArrayList<>());

    AtualizarClienteDTO atualizarCliente = AtualizarClienteDTOMock.getMock();
    atualizarCliente.setCpf("12345678910");

    when(repository.findById(1L)).thenReturn(Optional.of(entity));
    mockMvc.perform(
        put("/cliente")
            .contentType("application/json")
            .content(new Gson().toJson(atualizarCliente))
        )
        .andExpect(status().isAccepted());
  }

  @Test
  public void testExcluirCliente() throws Exception {
    when(repository.existsById(1L)).thenReturn(true);

    mockMvc.perform(delete("/cliente/id/{id}", 1L))
        .andExpect(status().isOk());
  }


}
