package ba.ssa.desafio.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ba.ssa.desafio.domain.Cliente;
import ba.ssa.desafio.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;
	
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listar() {

		List<Cliente> lista = this.clienteService.listar();

		return ResponseEntity.ok(lista);

	}
	

}
