package ba.ssa.desafio.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import ba.ssa.desafio.domain.Cliente;
import ba.ssa.desafio.domain.Conta;
import ba.ssa.desafio.repository.ContaRepository;
import ba.ssa.desafio.service.impl.ClienteServiceImpl;
import ba.ssa.desafio.service.impl.ContaServiceImpl;

@RunWith(SpringRunner.class)
public class ContaServiceTest {
	
	@MockBean
	private ContaRepository contaRepository;
	
	private ContaService contaService;
	
	private Conta contaTest;
	
	@Before
	public void setUp() {
		
		this.contaService = new ContaServiceImpl(this.contaRepository);
		
		this.contaTest = new Conta(new Cliente("000100200344", "Cliente Test"), 500.0);
		
		when(contaRepository.findById(this.contaTest.getId())).thenReturn(Optional.empty());
		
	}
	
	@Test
	public void teste_criar_conta_no_repository() {
		
		this.contaService.criar(this.contaTest);
		
		verify(this.contaRepository).save(this.contaTest);
		
	}
	
	@Test
	public void teste_deposito_repository() {
		
		when(contaRepository.findById(this.contaTest.getId())).thenReturn(Optional.of(this.contaTest));
		
		this.contaTest.deposito(150.0);
		
		this.contaService.alterar(this.contaTest);
		
		double saldo = this.contaService.obter(this.contaTest.getId()).getSaldo();
		
		assertThat(saldo).isEqualTo(650.0);
		
	}	
	
	@Test
	public void teste_saque_repository() {
		
		when(contaRepository.findById(this.contaTest.getId())).thenReturn(Optional.of(this.contaTest));
		
		this.contaTest.saque(150.0);
		
		this.contaService.alterar(this.contaTest);
		
		double saldo = this.contaService.obter(this.contaTest.getId()).getSaldo();
		
		assertThat(saldo).isEqualTo(350.0);
		
	}		

}
