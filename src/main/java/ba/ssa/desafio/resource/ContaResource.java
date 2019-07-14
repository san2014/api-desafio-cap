package ba.ssa.desafio.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ba.ssa.desafio.domain.Conta;
import ba.ssa.desafio.service.ContaService;

@RestController
@RequestMapping("/conta")
public class ContaResource {
	
	@Autowired
	private ContaService contaService;
	
	@GetMapping()
	public ResponseEntity<List<Conta>> listar() { 
		
		List<Conta> contas = this.contaService.listar();
		
		return ResponseEntity.ok(contas);
		
	}	
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Conta> obter(@PathVariable Long id) { 
		
		Conta conta = this.contaService.obter(id);
		
		return ResponseEntity.ok(conta);
		
	}
	
	@PutMapping
	@RequestMapping("/saque/{id}/{valor}")
	public ResponseEntity<Conta> saque(@PathVariable("id") Long id, @PathVariable("valor") double valor ) {
		
		Conta conta = this.contaService.obter(id);
		
		conta.saque(valor);
		
		this.contaService.alterar(conta);
		
		return ResponseEntity.ok(conta);
		
	}
	
	@PutMapping
	@RequestMapping("/deposito/{id}/{valor}")
	public ResponseEntity<Conta> deposito(@PathVariable("id") Long id, @PathVariable("valor") double valor ) {
		
		Conta conta = this.contaService.obter(id);
		
		conta.deposito(valor);
		
		this.contaService.alterar(conta);
		
		return ResponseEntity.ok(conta);
		
	}	

}
