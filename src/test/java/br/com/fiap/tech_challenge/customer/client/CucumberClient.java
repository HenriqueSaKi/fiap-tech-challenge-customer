package br.com.fiap.tech_challenge.customer.client;


import br.com.fiap.tech_challenge.customer.adapters.driver.controller.model.request.AtualizarClienteDTO;
import br.com.fiap.tech_challenge.customer.adapters.driver.controller.model.request.CadastrarClienteDTO;
import br.com.fiap.tech_challenge.customer.core.domain.model.Cliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(
    name = "cucumber",
    url = "${server.host}" + ":${server.port}"
)
public interface CucumberClient {
  
  @GetMapping("/api/v1/actuator/health")
  ResponseEntity<String> healthCheck();

  @PostMapping("/api/v1/cliente")
  ResponseEntity<String> cadastrarCliente(
      @RequestBody CadastrarClienteDTO cadastrarClienteDTO);

  @GetMapping("/api/v1/cliente/{cpf}")
  ResponseEntity<Object> buscarClientePorCPF(
      @PathVariable String cpf);

  @PutMapping("/api/v1/cliente")
  ResponseEntity<String> atualizarCliente(
      @RequestBody AtualizarClienteDTO atualizarClienteDTO);

  @DeleteMapping("/api/v1/cliente/id/{id}")
  ResponseEntity<String> excluirCliente(
      @PathVariable Long id);

}
