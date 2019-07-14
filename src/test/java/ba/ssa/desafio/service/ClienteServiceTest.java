package ba.ssa.desafio.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import ba.ssa.desafio.domain.Cliente;
import ba.ssa.desafio.repository.ClienteRepository;
import ba.ssa.desafio.service.impl.ClienteServiceImpl;

@RunWith(SpringRunner.class)
public class ClienteServiceTest {
	
	@MockBean
	private ClienteRepository clienteRepository;
	
	private ClienteService clienteService;
	
	private Cliente clientTest;
	
	private String CPF = "00011122233378";
	
	@Before
	public void setUp() {
		
		this.clienteService = new ClienteServiceImpl(this.clienteRepository);
		
		this.clientTest = new Cliente("00011122233378", "Client Test");
		
		when(this.clienteRepository.findOneByCpf(this.clientTest.getCpf())).thenReturn(Optional.empty());
		
	}
	
	@Test
	public void deve_listar_clientes() {
		
		List<Cliente> clientes = this.clienteService.listar();
		
		verify(this.clienteRepository).findAll();
		
	}
	
	@Test
	public void deve_salvar_cliente_repository() {
		
		this.clienteService.salvar(this.clientTest);
		
		verify(this.clienteRepository).save(this.clientTest);
		
	}
	
	@Test(expected=RuntimeException.class)
	public void teste_duplicidade_cpf() {
		
		when(this.clienteRepository.findOneByCpf(this.CPF)).thenReturn(Optional.of(this.clientTest));
		
		this.clienteService.salvar(clientTest);
		
	}

}
