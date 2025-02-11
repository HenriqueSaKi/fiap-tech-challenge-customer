package br.com.fiap.tech_challenge.customer.client;


import br.com.fiap.tech_challenge.customer.adapters.driver.controller.model.request.CadastrarClienteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
    name = "cucumber",
    url = "${server.host}" + ":${server.port}"
)
public interface CucumberClient {
  
  @GetMapping("/api/v1/actuator/health")
  ResponseEntity<String> healthCheck();

  @PostMapping("/api/v1/customer")
  ResponseEntity<Object> cadastrarCliente(
      @RequestBody CadastrarClienteDTO cadastrarClienteDTO);

}
